package com.jpa.hibernate.app.repository;

import com.jpa.hibernate.app.entity.Passport;
import com.jpa.hibernate.app.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class StudentRepository {
  private Logger logger = LogManager.getLogger(this.getClass());
  @Autowired
  private EntityManager entityManager;

  public Student findById(Long id) {
    return entityManager.find(Student.class, id);
  }

  public void deleteById(Long id) {
    entityManager.remove(findById(id));
  }

  public Student save(Student Student){
    if(Student.getId() == null) {
     entityManager.persist(Student);
    } else {
      Student = entityManager.merge(Student);
    }
    return Student;
  }

  public void saveStudentWithPassport() {
    Passport passport = new Passport("Z123456");
    entityManager.persist(passport);
    Student student = new Student("Mike");
    student.setPassport(passport);
    entityManager.persist(student);
  }
}
