package lk.ems.project.project;

import lk.ems.project.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/ems/api/v1")
public class ProjectController {

    @Autowired
    ProjectServiceImpl projectService;

    @RequestMapping(value = "/projects/{page}" , method = RequestMethod.GET)
    public Page<Project> getAllProjects(@PathVariable("page") int page){
        return projectService.getAllProjects(page);
    }

    @RequestMapping(value = "/projects" , method = RequestMethod.POST)
    public Project saveProject(@RequestBody Project project){

        return projectService.saveProject(project);
    }

}
