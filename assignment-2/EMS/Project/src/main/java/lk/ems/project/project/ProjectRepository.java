package lk.ems.project.project;

import com.commons.model.emsmodel.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

    List<Project> findByProjectIdIn(List<Integer> projectIds);

}
