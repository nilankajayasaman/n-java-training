package lk.ems.emsui.ui_controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ui_controller {


    @RequestMapping("/")
    public String index(){

        return "index";
    }


    @RequestMapping("/home")
    public String home(){

        return "home";
    }


    @RequestMapping("/employee")
    public String employee(){

        return "employee";
    }


    @RequestMapping("/project")
    public String project(){

        return "project";
    }


    @RequestMapping("/task")
    public String task(){

        return "task";
    }


    @RequestMapping("/operation")
    public String operation(){

        return "operation";
    }

}
