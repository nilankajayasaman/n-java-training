package lk.ems.employee.operation;

import lk.ems.employee.conf.AccessTokenConfigure;
import lk.ems.employee.entity.Employee;
import lk.ems.employee.entity.Operation;
import lk.ems.employee.entity.Project;
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
    RestTemplate restTemplate;

    public Page<Operation> getEmployeeProjects(int employeeId, int page){
        Page<Operation> operations =operationRepository.findByEmployeeId(employeeId, PageRequest.of(page,10));
        TreeSet<Integer> projectIds = new TreeSet<>();
        operations.getContent().forEach((s) -> {
            projectIds.add(s.getProjectId());
        });
        String prIds = projectIds.toString().replace("[","").replace("]","");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(AccessTokenConfigure.getToken());
        HttpEntity<Employee> httpEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<Project[]> responseEntity =
                restTemplate.exchange("http://localhost:8383/ems/api/v1/projects/employee/{prList}",
                        HttpMethod.GET,
                        httpEntity, Project[].class,prIds);

       
        operations.getContent().forEach((prj)->{
                for (Project project:responseEntity.getBody()) {
                    if (prj.getProjectId()==project.getProjectId()){
                        prj.setProject(project);
                    }
                }
        });
        return operations;
    }

    public Page<Operation> getEmployeeProjectsTask(int employeeId,int projectId, int page){
        return operationRepository.findByEmployeeIdAndProjectId(employeeId,projectId, PageRequest.of(page,10));
    }

    public List<Operation> saveOperation(List<Operation> operation){
        return operationRepository.saveAll(operation);
    }


}
