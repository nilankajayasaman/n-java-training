package lk.ems.emsui.model;

import org.springframework.context.annotation.Scope;

@Scope("prototype")
public class EmployeeHasProject {

    private Integer operationId;

    private Operation operation;

    private Employee employee;

    private Project project;

    public EmployeeHasProject(Operation operation, Employee employee) {
        this.operation = operation;
        this.employee = employee;
    }

    public Integer getOperationId() {
        return operationId;
    }

    public void setOperationId(Integer operationId) {
        this.operationId = operationId;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project= project;
    }

}
