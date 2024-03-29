package lk.ems.emsui.controller;

import io.micrometer.core.instrument.util.JsonUtils;
import lk.ems.emsui.conf.AccessTokenConfigure;
import lk.ems.emsui.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import javax.annotation.security.RolesAllowed;
import javax.websocket.server.PathParam;
import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class Ui_Controller {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    Employee employee;

    @Autowired
    Project project;

    @Autowired
    Task task;

    @Autowired
    Operation operation;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){

        return "index";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(){

        return "home";
    }

    @RequestMapping(value = {"/employee"}, method = RequestMethod.GET)
    public String employee(Principal principal, Model model, @PathParam("page") Optional<Integer> page){
        model.addAttribute("principal",principal);

        int pageNo = 0;

        if (page.isPresent()){
            pageNo = page.get()-1;
        }

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(AccessTokenConfigure.getToken());

        HttpEntity<Employee> httpEntity = new HttpEntity<>(httpHeaders);

        ResponseEntity<HashMap> responseEntity =
                restTemplate.exchange("http://employee:8282/ems/api/v1/employees/page?page={pageNo}",
                        HttpMethod.GET,
                        httpEntity, HashMap.class,pageNo);

        int totalPages = (int)responseEntity.getBody().get("totalPages");
        if(totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
            model.addAttribute("previous", pageNo);
            model.addAttribute("current", pageNo+1);
            model.addAttribute("next", pageNo+2);
            model.addAttribute("totalPages", totalPages);
        }
        model.addAttribute("employees",responseEntity.getBody());
        return "employee/employee";
    }


    @RequestMapping(value = "/project", method = RequestMethod.GET)
    public String project(Principal principal, Model model, @PathParam("page") Optional<Integer> page){
        model.addAttribute("principal",principal);

        int pageNo = 0;

        if (page.isPresent()){
            pageNo = page.get()-1;
        }

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(AccessTokenConfigure.getToken());

        HttpEntity<Employee> httpEntity = new HttpEntity<>(httpHeaders);

        ResponseEntity<HashMap> responseEntity =
                restTemplate.exchange("http://project:8383/ems/api/v1/projects/page?=page={pageNo}",
                        HttpMethod.GET,
                       httpEntity, HashMap.class,pageNo);
        int totalPages = (int)responseEntity.getBody().get("totalPages");
        if(totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
            model.addAttribute("previous", pageNo);
            model.addAttribute("current", pageNo+1);
            model.addAttribute("next", pageNo+2);
            model.addAttribute("totalPages", totalPages);
        }

        model.addAttribute("projects",responseEntity.getBody());
        return "project/project";
    }


    @RequestMapping(value = "/task", method = RequestMethod.GET)
    public String task(Principal principal, Model model, @PathParam("page") Optional<Integer> page){
        model.addAttribute("principal",principal);

        int pageNo = 0;

        if (page.isPresent()){
            pageNo = page.get()-1;
        }

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(AccessTokenConfigure.getToken());

        HttpEntity<Employee> httpEntity = new HttpEntity<>(httpHeaders);

        ResponseEntity<HashMap> responseEntity =
                restTemplate.exchange("http://task:8484/ems/api/v1/tasks/page?page={pageNo}",
                        HttpMethod.GET,
                        httpEntity, HashMap.class,pageNo);
        int totalPages = (int)responseEntity.getBody().get("totalPages");
        if(totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
            model.addAttribute("previous", pageNo);
            model.addAttribute("current", pageNo+1);
            model.addAttribute("next", pageNo+2);
            model.addAttribute("totalPages", totalPages);
        }
        model.addAttribute("tasks",responseEntity.getBody());
        return "task/task";
    }



    @RequestMapping(value = "/operation", method = RequestMethod.GET)
    public String operation(Model model){

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(AccessTokenConfigure.getToken());

        HttpEntity<Employee> httpEntity = new HttpEntity<>(httpHeaders);

        ResponseEntity<ArrayList> responseEntity =
                restTemplate.exchange("http://employee:8282/ems/api/v1/employees",
                        HttpMethod.GET,
                        httpEntity, ArrayList.class);
        model.addAttribute("employees",responseEntity.getBody());
        responseEntity =
                restTemplate.exchange("http://task:8484/ems/api/v1/tasks",
                        HttpMethod.GET,
                        httpEntity, ArrayList.class);
        model.addAttribute("tasks",responseEntity.getBody());
        responseEntity =
                restTemplate.exchange("http://project:8383/ems/api/v1/projects",
                        HttpMethod.GET,
                        httpEntity, ArrayList.class);
        model.addAttribute("projects",responseEntity.getBody());
        model.addAttribute("operation",operation);
        return "operation/operation";
    }

    @RequestMapping(value = "employee/emp-reg", method = RequestMethod.GET)
    public String createEmployee(Model model){
        model.addAttribute("employee",employee);
        return "employee/emp-reg";
    }


    @RequestMapping(value = "project/pro-reg", method = RequestMethod.GET)
    public String createProject(Model model){
        model.addAttribute("project",project);
        return "project/pro-reg";
    }

    @RequestMapping(value = "task/task-reg", method = RequestMethod.GET)
    public String createTask(Model model){
        model.addAttribute("task",task);
        return "task/task-reg";
    }

    @RequestMapping(value = "employee/emp-projects/{empId}", method = RequestMethod.GET)
    public String getEmployeeProjects(@PathVariable("empId") int empId,@PathParam("page") Optional<Integer> page,Model model){

        int pageNo = 0;

        if (page.isPresent()){
            pageNo = page.get()-1;
        }


        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(AccessTokenConfigure.getToken());

        HttpEntity<EmployeeHasProject> httpEntity = new HttpEntity<>(httpHeaders);

        ResponseEntity<HashMap> responseEntity =
                restTemplate.exchange("http://employee:8282/ems/api/v1/operations/employee/{empId}?page={pageNo}",
                        HttpMethod.GET,
                        httpEntity, HashMap.class,empId,pageNo);
        if (responseEntity.getBody()!=null) {
            int totalPages = (int) ((Map) responseEntity.getBody().get("employeeHasProjects")).get("totalPages");
            if (totalPages > 0) {
                List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
                model.addAttribute("pageNumbers", pageNumbers);
                model.addAttribute("previous", pageNo);
                model.addAttribute("current", pageNo + 1);
                model.addAttribute("next", pageNo + 2);
                model.addAttribute("totalPages", totalPages);
            }

            model.addAttribute("operation", responseEntity.getBody().get("employeeHasProjects"));
            model.addAttribute("employee", responseEntity.getBody().get("employee"));
            return "employee/emp-projects";
        }
        return "redirect:/employee";
    }


    @RequestMapping(value = "employee/emp-project-task/{empId}/{proId}", method = RequestMethod.GET)
    public String getEmployeeProjects(@PathVariable("empId") int empId,@PathVariable("proId") int proId,
                                      @PathParam("page") Optional<Integer> page,Model model){

        int pageNo = 0;

        if (page.isPresent()){
            pageNo = page.get()-1;
        }


        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(AccessTokenConfigure.getToken());

        HttpEntity<EmployeeProjectHasTask> httpEntity = new HttpEntity<>(httpHeaders);

        ResponseEntity<HashMap> responseEntity =
                restTemplate.exchange("http://employee:8282/ems/api/v1/operations/employee/{empId}/project/{proId}?=page={pageNo}",
                        HttpMethod.GET,
                        httpEntity, HashMap.class,empId,proId,pageNo);
        if (responseEntity.getBody()!=null &&
                responseEntity.getBody().get("employeeProjectHasTasks")!=null) {
            int totalPages = (int) ((Map) responseEntity.getBody().get("employeeProjectHasTasks")).get("totalPages");
            if (totalPages > 0) {
                List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
                model.addAttribute("pageNumbers", pageNumbers);
                model.addAttribute("previous", pageNo);
                model.addAttribute("current", pageNo + 1);
                model.addAttribute("next", pageNo + 2);
                model.addAttribute("totalPages", totalPages);
            }

            model.addAttribute("operation",responseEntity.getBody().get("employeeProjectHasTasks"));
            model.addAttribute("employee",responseEntity.getBody().get("employee"));
            model.addAttribute("project",responseEntity.getBody().get("project"));
            return "employee/emp-tasks";
        }
        return "redirect:/employee/emp-projects/"+empId;
    }

}
