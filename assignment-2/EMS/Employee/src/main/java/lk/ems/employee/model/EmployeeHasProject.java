package lk.ems.employee.model;

import com.commons.model.emsmodel.project.Project;
import com.commons.model.emsmodel.employee.Operation;
import org.springframework.context.annotation.Scope;

import java.io.Serializable;
import java.util.Objects;

//@Scope("prototype")
public class EmployeeHasProject implements Serializable{

    private Operation operation;


    private Project project;

    public EmployeeHasProject(Operation operation) {
        this.operation = operation;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project= project;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeHasProject that = (EmployeeHasProject) o;
        return Objects.equals(project, that.project);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, project);
    }
}
