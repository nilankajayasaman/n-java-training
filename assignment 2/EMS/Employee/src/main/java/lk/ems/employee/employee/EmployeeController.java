package lk.ems.employee.employee;

import lk.ems.employee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ems/api/v1")
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeService;

    @RequestMapping(value = "/employees/{page}" , method = RequestMethod.GET)
    public Page<Employee> getAllEmployees(@PathVariable("page") int page){

        return employeeService.getAllEmployees(page);
    }

    @RequestMapping(value = "/employees" , method = RequestMethod.POST)
    public Employee saveEmployees(@RequestBody Employee employee){

        return employeeService.saveEmployee(employee);
    }

}
