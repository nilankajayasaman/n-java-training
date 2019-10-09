package lk.ems.employee.operation;

import lk.ems.employee.entity.Operation;
import lk.ems.employee.model.EmployeeHasProject;
import lk.ems.employee.model.EmployeeProjectHasTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ems/api/v1")
public class OperationController {

    @Autowired
    OperationServiceImpl employeeService;

    @RequestMapping(value = "/operations/{employeeId}/{page}" , method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('read')")
    public Page<EmployeeHasProject> getEmployeeProject(@PathVariable("employeeId") int employeeId, @PathVariable("page") int page) {
        return employeeService.getEmployeeProjects(employeeId, page);
    }

    @RequestMapping(value = "/operations/{employeeId}/{projectId}/{page}" , method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('read')")
    public Page<EmployeeProjectHasTask> getEmployeeProjectTasks(@PathVariable("employeeId") int employeeId,
            @PathVariable("projectId") int projectId,@PathVariable("page") int page){
        return employeeService.getEmployeeProjectsTask(employeeId,projectId,page);
    }

    @RequestMapping(value = "/operations" , method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('MANAGER')")
    public List<Operation> saveOperation(@RequestBody List<Operation> operation){
        return employeeService.saveOperation(operation);
    }

}
