package com.jpa.hibernate.app.services;

import com.jpa.hibernate.app.entity.Student;
import com.jpa.hibernate.app.repository.StudentRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  @Autowired
  private StudentRepositoryJpa studentRepositoryJpa;

  public Student findStudentById(Long id) {
    return studentRepositoryJpa.findStudentById(id);
  }
}
