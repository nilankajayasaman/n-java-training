package com.training.springdatajpaexample.repository;

import com.training.springdatajpaexample.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
