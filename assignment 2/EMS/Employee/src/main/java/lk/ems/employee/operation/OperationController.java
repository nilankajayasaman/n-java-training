package lk.ems.employee.operation;

import lk.ems.employee.entity.Employee;
import lk.ems.employee.entity.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ems/api/v1")
public class OperationController {

    @Autowired
    OperationServiceImpl employeeService;

    @RequestMapping(value = "/operations/{page}" , method = RequestMethod.GET)
    public Page<Operation> getAllOperation(@PathVariable("page") int page){

        return employeeService.getAllOperation(page);
    }

    @RequestMapping(value = "/operations" , method = RequestMethod.POST)
    public Operation saveOperation(@RequestBody Operation operation){

        return employeeService.saveOperation(operation);
    }

}
