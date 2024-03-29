package lk.ems.employee.model;

import com.commons.model.emsmodel.project.Project;
import com.commons.model.emsmodel.employee.Employee;
import org.springframework.data.domain.Page;

public class EmployeeProjectTask {


    private Employee employee;

    private Project project;

    private Page<EmployeeProjectHasTask> employeeProjectHasTasks;

    public EmployeeProjectTask(Employee employee,Project project) {
        this.employee = employee;
        this.project = project;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Page<EmployeeProjectHasTask> getEmployeeProjectHasTasks() {
        return employeeProjectHasTasks;
    }

    public void setEmployeeProjectHasTasks(Page<EmployeeProjectHasTask> employeeProjectHasTasks) {
        this.employeeProjectHasTasks = employeeProjectHasTasks;
    }
}
