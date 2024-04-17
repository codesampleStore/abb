package com.jpa.hibernate.app.repository;

import com.jpa.hibernate.app.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseRepository {
  private Logger logger = LogManager.getLogger(this.getClass());
  @Autowired
  private EntityManager entityManager;

  public Course findById(Long id) {
    return entityManager.find(Course.class, id);
  }

  public void deleteById(Long id) {
    entityManager.remove(findById(id));
  }

  public Course save(Course course){
    if(course.getId() == null) {
     entityManager.persist(course);
    } else {
      course = entityManager.merge(course);
    }
    return course;
  }

  public void playWithEntityManager() {
    /*logger.info("playWithEntityManager START");
    Course c1 = new Course("WebServices in 100 Steps");
    entityManager.persist(c1);
    entityManager.flush();

    c1.setName("Web Services in 10 days"); // it will be saved in DB because of Transactional, EntityManager keeps state of 'c'
    entityManager.flush();

    Course c2 = new Course("GenAI in 100 Steps");
    entityManager.persist(c2);
    entityManager.flush();

    //entityManager.detach(c2); // changes in c2 are no longer track by EntityManager
    //entityManager.clear(); // clear everything that is being tracked
    c2.setName("GenAI in 100 Steps - New ");
    entityManager.refresh(c2);
    System.out.println("C2:"+ c2);
    entityManager.flush();*/

    Course course = findById(10005L);
    course.setName(course.getName()+"_updated");
    entityManager.persist(course);
    entityManager.flush();
  }
}
