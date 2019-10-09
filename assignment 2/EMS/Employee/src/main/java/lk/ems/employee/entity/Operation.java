package lk.ems.employee.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "operation")
@IdClass(OperationKey.class)
public class Operation {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer operationId;

    @OneToOne
    @JoinColumn(name = "employeeId",insertable = false, updatable = false)
    private Employee employee;

    @Id
    private Integer employeeId;

    @Id
    private Integer projectId;

    @Id
    private Integer taskId;

    @Transient
    private Project project;
//
//    public Integer getOperationId() {
//        return operationId;
//    }
//
//    public void setOperationId(Integer operationId) {
//        this.operationId = operationId;
//    }

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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project= project;
    }
}
