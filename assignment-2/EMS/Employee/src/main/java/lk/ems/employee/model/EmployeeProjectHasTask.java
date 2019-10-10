package lk.ems.employee.model;

import lk.ems.employee.entity.Operation;
import lk.ems.employee.entity.Task;
import org.springframework.context.annotation.Scope;

import java.io.Serializable;
import java.util.Objects;

//@Scope("prototype")
public class EmployeeProjectHasTask {

    private Operation operation;

    private Task task;

    public EmployeeProjectHasTask(Operation operation) {
        this.operation = operation;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeProjectHasTask that = (EmployeeProjectHasTask) o;
        return Objects.equals(operation, that.operation) &&
                Objects.equals(task, that.task);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, task);
    }
}
