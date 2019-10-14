package lk.ems.task.task;

import com.commons.model.emsmodel.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl {

    @Autowired
    TaskRepository taskRepository;

    public Page<Task> getLimitTask(int page){
        return taskRepository.findAll(PageRequest.of(page,10));
    }

    public List<Task> getAllTask(){
        return taskRepository.findAll();
    }

    public List<Task> getEmployeeProjectTask(List<Integer> taskList){
        return taskRepository.findByTaskIdIn(taskList);
    }

    public Task saveTask(Task employee){
        return taskRepository.save(employee);
    }


}
