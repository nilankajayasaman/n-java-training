package lk.ems.emsui.model;

import org.springframework.context.annotation.Scope;
import org.springframework.data.annotation.Transient;

import java.util.List;

@Scope("prototype")
public class Operation {

    private Integer operationId;

    private Integer employeeId;

    @Transient
    private Employee employee;

    private Integer projectId;

    private Integer taskId;

    @Transient
    private List<Integer> taskList;

    @Transient
    private Project project;

    public Integer getOperationId() {
        return operationId;
    }

    public void setOperationId(Integer operationId) {
        this.operationId = operationId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public List<Integer> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Integer> taskList) {
        this.taskList = taskList;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project= project;
    }
}
