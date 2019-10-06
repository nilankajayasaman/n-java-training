package lk.ems.task.task;

import lk.ems.task.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ems/api/v1")
public class TaskController {

    @Autowired
    TaskServiceImpl taskService;

    @RequestMapping(value = "/tasks/{page}" , method = RequestMethod.GET)
    public Page<Task> getAllTasks(@PathVariable("page") int page){

        return taskService.getAllTask(page);
    }

    @RequestMapping(value = "/tasks" , method = RequestMethod.POST)
    public Task saveTask(@RequestBody Task task){

        return taskService.saveTask(task);
    }

}
