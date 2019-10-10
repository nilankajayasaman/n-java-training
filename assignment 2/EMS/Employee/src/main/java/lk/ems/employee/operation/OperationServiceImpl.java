package lk.ems.employee.operation;

import com.sun.deploy.net.HttpResponse;
import lk.ems.employee.conf.AccessTokenConfigure;
import lk.ems.employee.employee.EmployeeRepository;
import lk.ems.employee.entity.Employee;
import lk.ems.employee.entity.Operation;
import lk.ems.employee.entity.Project;
import lk.ems.employee.entity.Task;
import lk.ems.employee.model.EmployeeHasProject;
import lk.ems.employee.model.EmployeeProject;
import lk.ems.employee.model.EmployeeProjectHasTask;
import lk.ems.employee.model.EmployeeProjectTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

@Service
public class OperationServiceImpl {

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    RestTemplate restTemplate;

    public ResponseEntity getEmployeeProjects(int employeeId, int page){
        try {

        Page<EmployeeHasProject> ehp =operationRepository.getOperationByEmployeeId(employeeId, PageRequest.of(page,10));
        TreeSet<Integer> projectIds = new TreeSet<>();
        ehp.getContent().forEach((s) -> {
            projectIds.add(s.getOperation().getProjectId());
        });
        String prIds = projectIds.toString().replace("[","").replace("]","");
        if (!prIds.equals("")) {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setBearerAuth(AccessTokenConfigure.getToken());
            HttpEntity<Employee> httpEntity = new HttpEntity<>(httpHeaders);
            ResponseEntity<Project[]> responseEntity =
                    restTemplate.exchange("http://localhost:8383/ems/api/v1/projects/employee/{prList}",
                            HttpMethod.GET,
                            httpEntity, Project[].class, prIds);

            ehp.getContent().forEach((prj) -> {
                for (Project project : responseEntity.getBody()) {
                    if (prj.getOperation().getProjectId() == project.getProjectId()) {
                        prj.setProject(project);
                    }
                }
            });
            EmployeeProject employeeProject = new EmployeeProject(employeeRepository.getOne(employeeId));
            employeeProject.setEmployeeHasProjects(ehp);
            return ResponseEntity.ok().body(employeeProject);
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.ok().body(null);
    }

    public ResponseEntity getEmployeeProjectsTask(int employeeId,int projectId, int page){

        Page<EmployeeProjectHasTask> epht =
                operationRepository.getEmployeeTasks(employeeId,projectId, PageRequest.of(page,10));


        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(AccessTokenConfigure.getToken());
        HttpEntity<Employee> httpEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<Project[]> responseEntity =
                restTemplate.exchange("http://localhost:8383/ems/api/v1/projects/employee/{prList}",
                        HttpMethod.GET,
                        httpEntity, Project[].class,projectId);

        TreeSet<Integer> taskIds = new TreeSet<>();
        epht.getContent().forEach((s) -> {
            taskIds.add(s.getOperation().getTaskId());
        });
        String tskIds = taskIds.toString().replace("[","").replace("]","");

        if (!tskIds.equals("")) {
            ResponseEntity<Task[]> responseEntityTask =
                    restTemplate.exchange("http://localhost:8484/ems/api/v1/tasks/",
                            HttpMethod.GET,
                            httpEntity, Task[].class, projectId);

            epht.getContent().forEach((prj) -> {
                for (Task task : responseEntityTask.getBody()) {
                    if (prj.getOperation().getTaskId() == task.getTaskId()) {
                        prj.setTask(task);
                    }
                }
            });

            EmployeeProjectTask employeeProjectTask =
                    new EmployeeProjectTask(employeeRepository.getOne(employeeId),responseEntity.getBody()[0]);
            employeeProjectTask.setEmployeeProjectHasTasks(epht);
            return ResponseEntity.ok().body(employeeProjectTask);
        }
        return ResponseEntity.ok().body(null);
    }

    public List<Operation> saveOperation(List<Operation> operation){
        return operationRepository.saveAll(operation);
    }



}
