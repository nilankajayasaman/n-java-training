package lk.ems.project.project;

import com.commons.model.emsmodel.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAuthority('read')")
    public List<Project> getAllProjects(){
        return projectService.getAllProjects();
    }

    @RequestMapping(value = "/projects/{page}" , method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('read')")
    public Page<Project> getLimitProjects(@PathVariable("page") int page){
        return projectService.getLimitProjects(page);
    }

    @RequestMapping(value = "/projects/employee/{prList}" , method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('read')")
    public List<Project> getProjectList(@PathVariable("prList") List<Integer> prList){
        return projectService.getEmployeeProjects(prList);
    }


    @RequestMapping(value = "/projects" , method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('MANAGER')")
    public Project saveProject(@RequestBody Project project){

        return projectService.saveProject(project);
    }

}
