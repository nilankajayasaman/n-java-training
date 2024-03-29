package lk.ems.task.task;

import com.commons.model.emsmodel.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    List<Task> findByTaskIdIn(List<Integer> taskIds);

}
