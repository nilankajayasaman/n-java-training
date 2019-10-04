package lk.ems.emsui.controller;

import io.micrometer.core.instrument.util.JsonUtils;
import lk.ems.emsui.conf.AccessTokenConfigure;
import lk.ems.emsui.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@Controller
public class Ui_Controller {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){

        return "index";
    }


    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(){

        return "home";
    }


    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String employee(Principal principal, Model model){
        model.addAttribute("principal",principal);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(AccessTokenConfigure.getToken());

        HttpEntity<Employee> studentHttpEntity = new HttpEntity<>(httpHeaders);
        ParameterizedTypeReference<Page<Employee>> responseType = new ParameterizedTypeReference<Page<Employee>>() { };

        ResponseEntity<HashMap> responseEntity =
                restTemplate.exchange("http://localhost:8282/ems/api/v1/employees/0",
                        HttpMethod.GET,
                        studentHttpEntity, HashMap.class);


        System.out.println(responseEntity.getBody());
        model.addAttribute("employees",responseEntity.getBody());
        return "employee/employee";
    }


    @RequestMapping(value = "/project", method = RequestMethod.GET)
    public String project(){

        return "project/project";
    }


    @RequestMapping(value = "/task", method = RequestMethod.GET)
    public String task(){

        return "task/task";
    }


    @RequestMapping(value = "/operation", method = RequestMethod.GET)
    public String operation(){

        return "operation/operation";
    }


    @RequestMapping(value = "employee/emp-reg", method = RequestMethod.GET)
    public String createEmployee(){
        return "employee/emp-reg";
    }

    @RequestMapping(value = "project/pro-reg", method = RequestMethod.GET)
    public String createProject(){
        return "project/pro-reg";
    }

    @RequestMapping(value = "task/task-reg", method = RequestMethod.GET)
    public String createTask(){
        return "task/task-reg";
    }

    @RequestMapping(value = "employee/emp-projects/{empId}", method = RequestMethod.GET)
    public String getEmployeeProjects(@PathVariable("empId") int empId){
        return "employee/emp-projects";
    }
}
