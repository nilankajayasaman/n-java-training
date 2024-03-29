package lk.ems.employee.operation;

import com.commons.model.emsmodel.employee.Operation;
import lk.ems.employee.model.EmployeeHasProject;
import lk.ems.employee.model.EmployeeProjectHasTask;
import lk.ems.employee.model.EmployeeProjectTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/ems/api/v1")
public class OperationController {

    @Autowired
    OperationServiceImpl employeeService;

    @RequestMapping(value = "/operations/employee/{employeeId}" , method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('read')")
    public ResponseEntity getEmployeeProject(@PathVariable("employeeId") int employeeId, @RequestParam("page") int page) throws Exception {
        return employeeService.getEmployeeProjects(employeeId, page);
    }

    @RequestMapping(value = "/operations/employee/{employeeId}/project/{projectId}" , method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('read')")
    public ResponseEntity getEmployeeProjectTasks(@PathVariable("employeeId") int employeeId,
                                                  @PathVariable("projectId") int projectId, @RequestParam("page") int page){

        return employeeService.getEmployeeProjectsTask(employeeId,projectId,page);
    }

    @RequestMapping(value = "/operations" , method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('MANAGER')")
    public List<Operation> saveOperation(@RequestBody List<Operation> operation){
        return employeeService.saveOperation(operation);
    }

}
