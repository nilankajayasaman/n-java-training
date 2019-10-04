package lk.ems.project.project;

import lk.ems.project.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ems/api/v1")
public class ProjectController {

    @Autowired
    ProjectServiceImpl projectService;

    @RequestMapping(value = "/projects/{page}" , method = RequestMethod.GET)
    public Page<Project> getAllEmployees(@PathVariable("page") int page){

        return projectService.getAllProjects(page);
    }

    @RequestMapping(value = "/projects" , method = RequestMethod.POST)
    public Project saveEmployees(@RequestBody Project employee){

        return projectService.saveProject(employee);
    }

}
