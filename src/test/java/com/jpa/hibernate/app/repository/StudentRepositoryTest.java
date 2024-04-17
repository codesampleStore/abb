package com.jpa.hibernate.app.repository;

import com.jpa.hibernate.app.AppApplication;
import com.jpa.hibernate.app.entity.Course;
import com.jpa.hibernate.app.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppApplication.class)
class StudentRepositoryTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	@Autowired
	StudentRepository repository;

	@Autowired
	EntityManager entityManager;

	@Test
	void shouldFindStudentAndPassport() {
		Student student = entityManager.find(Student.class, 20001L);
		logger.info("student -> {}" , student);
		logger.info("passport -> {}" , student.getPassport());
	}

}
