package lk.ems.employee.employee;

import com.commons.model.emsmodel.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Page<Employee> getLimitEmployees(int page){
        return employeeRepository.findAll(PageRequest.of(page,10));
    }

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }


}
