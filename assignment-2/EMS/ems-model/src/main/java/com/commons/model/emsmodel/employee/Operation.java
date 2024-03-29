package com.commons.model.emsmodel.employee;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "operation")
@IdClass(OperationKey.class)
public class Operation implements Serializable {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer operationId;

//    @JsonIgnore
//    @OneToOne
//    @JoinColumn(name = "employeeId",insertable = false, updatable = false)
//    private Employee employee;

    @Id
    private Integer employeeId;

    @Id
    private Integer projectId;

    @Id
    private Integer taskId;


    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
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

}
