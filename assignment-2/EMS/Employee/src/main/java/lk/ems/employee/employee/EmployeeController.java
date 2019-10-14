package lk.ems.employee.employee;

import com.commons.model.emsmodel.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/ems/api/v1")
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeService;

    @RequestMapping(value = "/employees/page" , method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('read')")
    public Page<Employee> getLimitEmployees(@RequestParam("page") int page){
        return employeeService.getLimitEmployees(page);
    }

    @RequestMapping(value = "/employees" , method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('read')")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @RequestMapping(value = "/employees" , method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('MANAGER')")
    public Employee saveEmployees(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

}
