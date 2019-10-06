package lk.ems.emsui.model;

import org.springframework.context.annotation.Scope;

import javax.validation.constraints.NotBlank;

@Scope("prototype")
public class Task {

    private Integer taskId;

    @NotBlank(message = "Title is mandatory")
    private String taskTitle;

    @NotBlank(message = "Description is mandatory")
    private String taskDescription;

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
}
