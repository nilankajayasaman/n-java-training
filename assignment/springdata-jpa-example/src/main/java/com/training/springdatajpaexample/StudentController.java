package com.training.springdatajpaexample;

import com.training.springdatajpaexample.Entity.Address;
import com.training.springdatajpaexample.Entity.Student;
import com.training.springdatajpaexample.Entity.Telephone;
import com.training.springdatajpaexample.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sms")
public class StudentController {

    @Autowired
    StudentServiceImpl studentService;

    @RequestMapping(value = "/hello")
    public String greeting(){
        return "hello Springboot";
    }

    @RequestMapping(value = "/student",method = RequestMethod.POST)
    public Student save(@RequestBody Student student){

        for (Telephone tel: student.getTelephones()) {
            tel.setStudent(student);
        }

        return studentService.save(student);
    }


//    @RequestMapping(value = "/student",method = RequestMethod.GET)
//    public Student getStudent(){
//        Student student = new Student();
//        student.setName("Saman");
//        Address address = new Address();
//        address.setCity("Galle");
//        student.setAddress(address);
//
//        List<Telephone> telephones = new ArrayList<>();
//        Telephone telephone = new Telephone();
//        telephone.setTelephoneNumber("086532354");
//        telephone.setStudent(student);
//        telephones.add(telephone);
//
//        student.setTelephones(telephones);
//        return student;
//    }
//

    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public List<Student> fetchAll(Optional<Integer> id){

        return studentService.findAll();
    }

    @RequestMapping(value = "/student/{id}",method = RequestMethod.GET)
    public Optional<Student> findById(@PathVariable Integer id){
        return studentService.findById(id);
    }

}
