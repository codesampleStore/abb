package com.jpa.hibernate.app.controller;

import com.jpa.hibernate.app.entity.Student;
import com.jpa.hibernate.app.exception.StudentNotFoundException;
import com.jpa.hibernate.app.repository.StudentRepository;
import com.jpa.hibernate.app.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/student")
@Validated
public class StudentController {

  @Autowired
  private StudentService studentService;

  @GetMapping(value = "/{id}")
  public Student getStudentById(@PathVariable(name = "id") @Positive Long id) {
    Student student = studentService.findStudentById(id);
    if(student == null) {
      throw new StudentNotFoundException(String.format("Student ID %s not found.", id));
    }
    return student;
  }
}
