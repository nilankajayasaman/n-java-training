package lk.ems.project.project;

import com.commons.model.emsmodel.project.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class ProjectServiceImpl {

    @Autowired
    ProjectRepository projectRepository;

    public List<Project> getAllProjects(){
        return projectRepository.findAll();
    }

    public Page<Project> getLimitProjects(int page){
        return projectRepository.findAll(PageRequest.of(page,10));
    }

    public List<Project> getEmployeeProjects(List<Integer> projectIds){
        return projectRepository.findByProjectIdIn(projectIds);
    }

    public Project saveProject(Project project){
        return projectRepository.save(project);
    }


}
