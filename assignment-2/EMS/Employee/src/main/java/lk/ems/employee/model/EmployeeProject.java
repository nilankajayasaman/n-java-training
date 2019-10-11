package lk.ems.employee.model;

import com.commons.model.emsmodel.Employee;
import org.springframework.data.domain.Page;

import java.io.Serializable;

public class EmployeeProject implements Serializable {

    private Employee employee;

    private Page<EmployeeHasProject> employeeHasProjects;

    public EmployeeProject(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployeeHasProjects(Page<EmployeeHasProject> employeeHasProjects) {
        this.employeeHasProjects = employeeHasProjects;
    }


    public Page<EmployeeHasProject> getEmployeeHasProjects() {
        return employeeHasProjects;
    }
}
