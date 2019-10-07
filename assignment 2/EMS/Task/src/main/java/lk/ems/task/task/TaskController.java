package lk.ems.task.task;

import lk.ems.task.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ems/api/v1")
public class TaskController {

    @Autowired
    TaskServiceImpl taskService;

    @RequestMapping(value = "/tasks/{page}" , method = RequestMethod.GET)
    public Page<Task> getLimitTasks(@PathVariable("page") int page){

        return taskService.getLimitTask(page);
    }

    @RequestMapping(value = "/tasks" , method = RequestMethod.GET)
    public List<Task> getAllTasks(){

        return taskService.getAllTask();
    }

    @RequestMapping(value = "/tasks" , method = RequestMethod.POST)
    public Task saveTask(@RequestBody Task task){

        return taskService.saveTask(task);
    }

}
