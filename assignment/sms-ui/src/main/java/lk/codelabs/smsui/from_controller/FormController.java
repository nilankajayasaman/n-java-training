package lk.codelabs.smsui.from_controller;

import lk.codelabs.smsui.from_model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Controller
public class FormController {

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(HttpServletRequest httpServletRequest, @ModelAttribute("student")Student student){

        System.out.println(student.getName());
        System.out.println(student.getCity());

//        Enumeration enumeration = httpServletRequest.getParameterNames();
//        while (enumeration.hasMoreElements()){
//            System.out.println(enumeration.nextElement());
//        }
        return "new_student";
    }

}
