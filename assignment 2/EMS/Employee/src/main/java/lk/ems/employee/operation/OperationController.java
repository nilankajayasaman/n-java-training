package lk.ems.employee.operation;

import lk.ems.employee.entity.Employee;
import lk.ems.employee.entity.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.TreeSet;

@RestController
@RequestMapping("/ems/api/v1")
public class OperationController {

    @Autowired
    OperationServiceImpl employeeService;

    @RequestMapping(value = "/operations/{employeeId}/{page}" , method = RequestMethod.GET)
    public Page<Operation> getEmployeeProject(@PathVariable("employeeId") int employeeId, @PathVariable("page") int page) {
        return employeeService.getEmployeeProjects(employeeId, page);
    }

    @RequestMapping(value = "/operations/{employeeId}/{projectId}/{page}" , method = RequestMethod.GET)
    public Page<Operation> getEmployeeProjectTasks(@PathVariable("employeeId") int employeeId,
            @PathVariable("projectId") int projectId,@PathVariable("page") int page){
        Page<Operation> operations = employeeService.getEmployeeProjectsTask(employeeId,projectId,page);
        String projectIds = "";
        operations.getContent().forEach((s)->{
            System.out.println(s);
        });
        return employeeService.getEmployeeProjectsTask(employeeId,projectId,page);
    }

    @RequestMapping(value = "/operations" , method = RequestMethod.POST)
    public List<Operation> saveOperation(@RequestBody List<Operation> operation){

        return employeeService.saveOperation(operation);
    }

}
