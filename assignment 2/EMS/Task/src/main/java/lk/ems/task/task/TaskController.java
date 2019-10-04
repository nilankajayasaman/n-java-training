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

    @RequestMapping(value = "/task/{page}" , method = RequestMethod.GET)
    public Page<Task> getAllEmployees(@PathVariable("page") int page){

        return taskService.getAllTask(page);
    }

    @RequestMapping(value = "/task" , method = RequestMethod.POST)
    public Task saveEmployees(@RequestBody Task task){

        return taskService.saveTask(task);
    }

}
