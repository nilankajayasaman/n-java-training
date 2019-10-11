package com.commons.model.emsmodel;

import java.io.Serializable;
import java.util.Objects;

public class OperationKey implements Serializable {
    private Integer employeeId;
    private Integer projectId;
    private Integer taskId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperationKey that = (OperationKey) o;
        return Objects.equals(employeeId, that.employeeId) &&
                Objects.equals(projectId, that.projectId) &&
                Objects.equals(taskId, that.taskId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, projectId, taskId);
    }
}
