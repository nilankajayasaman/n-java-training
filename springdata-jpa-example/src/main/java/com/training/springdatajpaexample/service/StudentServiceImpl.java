package com.training.springdatajpaexample.service;

import com.training.springdatajpaexample.Entity.Student;
import com.training.springdatajpaexample.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl {

    @Autowired
    StudentRepository studentRepository;

    public Student save(Student student){

       return studentRepository.save(student);
    }


    public List<Student> findAll(){

        return studentRepository.findAll();
    }

    public Optional<Student> findById(Integer id){

        return studentRepository.findById(id);
    }

}
