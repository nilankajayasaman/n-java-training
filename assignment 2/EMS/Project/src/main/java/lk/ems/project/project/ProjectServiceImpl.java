package lk.ems.project.project;

import lk.ems.project.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class ProjectServiceImpl {

    @Autowired
    ProjectRepository projectRepository;

    public Page<Project> getAllProjects(int page){
        return projectRepository.findAll(PageRequest.of(page,10));
    }


    public Project saveProject(Project project){
        return projectRepository.save(project);
    }


}
