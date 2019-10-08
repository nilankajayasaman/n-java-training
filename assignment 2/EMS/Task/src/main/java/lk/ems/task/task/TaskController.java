package lk.ems.task.task;

import lk.ems.task.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ems/api/v1")
public class TaskController {

    @Autowired
    TaskServiceImpl taskService;

    @RequestMapping(value = "/tasks/{page}" , method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('read')")
    public Page<Task> getLimitTasks(@PathVariable("page") int page){

        return taskService.getLimitTask(page);
    }

    @RequestMapping(value = "/tasks" , method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('read')")
    public List<Task> getAllTasks(){

        return taskService.getAllTask();
    }

    @RequestMapping(value = "/tasks" , method = RequestMethod.POST)
    @PreAuthorize("hasRole('MANAGER')")
    public Task saveTask(@RequestBody Task task){

        return taskService.saveTask(task);
    }

    @RequestMapping(value = "/tasks/project/{taskList}" , method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('read')")
    public List<Task> getProjectList(@PathVariable("taskList") List<Integer> taskList){
        return taskService.getEmployeeProjectTask(taskList);
    }

}
