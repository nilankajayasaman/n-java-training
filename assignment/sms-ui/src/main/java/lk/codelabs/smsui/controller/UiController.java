package lk.codelabs.smsui.controller;

import lk.codelabs.smsui.from_model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
@EnableOAuth2Sso
public class UiController extends WebSecurityConfigurerAdapter {

    @Autowired
    Student student;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/")
                .permitAll()
                .anyRequest()
                .authenticated();
    }

    @RequestMapping(value = "/")
    public String index(Model model){

        return "index";
    }

    @RequestMapping(value = "/home")
    public String home(Model model,Principal principal){
        model.addAttribute("student",student);
        model.addAttribute("principal",principal);
        return "home";
    }

    @RequestMapping(value = "/create-student")
    public String newStudent(Model model, Principal principal){
        model.addAttribute("student",student);
        model.addAttribute("principal",principal);

        return "new_student";
    }

    @RequestMapping(value = "/update-student")
    public String updateStudent(Model model,Principal principal){
        model.addAttribute("student",student);
        model.addAttribute("principal",principal);
        return "update_student";
    }

    @RequestMapping(value = "/fetch-student")
    public String fetchStudent(Model model, Principal principal){
        model.addAttribute("principal",principal);
        return "fetch_student";
    }

    @RequestMapping(value = "/fetch-all-student")
    public String fetchAllStudent(Model model,Principal principal){
        model.addAttribute("principal",principal);
        return "fetch_all_student";
    }

}
