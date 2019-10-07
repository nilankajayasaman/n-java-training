package lk.ems.project.project;

import lk.ems.project.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/ems/api/v1")
public class ProjectController {

    @Autowired
    ProjectServiceImpl projectService;

    @RequestMapping(value = "/projects" , method = RequestMethod.GET)
    public List<Project> getAllProjects(){
        return projectService.getAllProjects();
    }

    @RequestMapping(value = "/projects/{page}" , method = RequestMethod.GET)
    public Page<Project> getLimitProjects(@PathVariable("page") int page){
        return projectService.getLimitProjects(page);
    }

    @RequestMapping(value = "/projects/employee/{prList}" , method = RequestMethod.GET)
    public List<Project> getProjectList(@PathVariable("prList") List<Integer> prList){
        return projectService.getEmployeeProjects(prList);
    }


    @RequestMapping(value = "/projects" , method = RequestMethod.POST)
    public Project saveProject(@RequestBody Project project){

        return projectService.saveProject(project);
    }

}
