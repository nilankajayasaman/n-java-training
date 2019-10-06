package lk.ems.emsui.controller;

import lk.ems.emsui.conf.AccessTokenConfigure;
import lk.ems.emsui.model.Employee;
import lk.ems.emsui.model.Project;
import lk.ems.emsui.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.HashMap;

@Controller
public class Form_Controller {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "employee/save-emp", method = RequestMethod.POST)
    public String saveEmployee(@Valid Employee employee,BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "employee/emp-reg";
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(AccessTokenConfigure.getToken());
        HttpEntity<Employee> httpEntity = new HttpEntity<>(employee,httpHeaders);
        try {
            ResponseEntity<Employee> responseEntity =
                    restTemplate.exchange("http://localhost:8282/ems/api/v1/employees",
                            HttpMethod.POST,
                            httpEntity, Employee.class);
            if (responseEntity.getStatusCodeValue() == 200) {
                redirectAttributes.addFlashAttribute("success", true);
                redirectAttributes.addFlashAttribute("massage", "Employee saved");
            } else {
                redirectAttributes.addFlashAttribute("error", true);
                redirectAttributes.addFlashAttribute("message", responseEntity.getStatusCode());
            }
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("error", true);
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            return "redirect:/employee/emp-reg";
        }
        return "redirect:/employee";
    }


    @RequestMapping(value = "project/save-project", method = RequestMethod.POST)
    public String saveProject(@Valid Project project, BindingResult bindingResult,
                              RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "project/pro-reg";
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(AccessTokenConfigure.getToken());
        HttpEntity<Employee> httpEntity = new HttpEntity(project,httpHeaders);
        try {
            ResponseEntity<Employee> responseEntity =
                    restTemplate.exchange("http://localhost:8383/ems/api/v1/projects",
                            HttpMethod.POST,
                            httpEntity, Employee.class);
            if (responseEntity.getStatusCodeValue() == 200) {
                redirectAttributes.addFlashAttribute("success", true);
                redirectAttributes.addFlashAttribute("massage", "Task saved");
            } else {
                redirectAttributes.addFlashAttribute("error", true);
                redirectAttributes.addFlashAttribute("message", responseEntity.getStatusCode());
            }
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("error", true);
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            return "redirect:/project/pro-reg";
        }
        return "redirect:/project";
    }





    @RequestMapping(value = "task/save-task", method = RequestMethod.POST)
    public String saveTask(@Valid Task task, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "task/task-reg";
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(AccessTokenConfigure.getToken());
        HttpEntity<Employee> httpEntity = new HttpEntity(task,httpHeaders);
        try {
            ResponseEntity<Employee> responseEntity =
                    restTemplate.exchange("http://localhost:8484/ems/api/v1/tasks",
                            HttpMethod.POST,
                            httpEntity, Employee.class);
            if (responseEntity.getStatusCodeValue() == 200) {
                redirectAttributes.addFlashAttribute("success", true);
                redirectAttributes.addFlashAttribute("massage", "Task saved");
            } else {
                redirectAttributes.addFlashAttribute("error", true);
                redirectAttributes.addFlashAttribute("message", responseEntity.getStatusCode());
            }
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("error", true);
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            return "redirect:/task/task-reg";
        }
        return "redirect:/task";
    }
}
