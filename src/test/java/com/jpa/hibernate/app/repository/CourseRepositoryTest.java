package com.jpa.hibernate.app.repository;

import com.jpa.hibernate.app.AppApplication;
import com.jpa.hibernate.app.entity.Course;
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

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppApplication.class)
class CourseRepositoryTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	@Autowired
	CourseRepository repository;

	@Autowired
	EntityManager entityManager;

	@Test
	void shouldFindCourse() {
		Course course = repository.findById(10001L);
		assertEquals("JPA in 50 Steps", course.getName());
	}

	@Test
	@DirtiesContext
	void shouldDeleteCourse() {
		repository.deleteById(10001L);
		assertNull(repository.findById(10001L));
	}


	@Test
	@DirtiesContext
	void shouldSaveCourse() {
		Course c = repository.save(new Course("C# in 1000 days"));
		assertEquals("C# in 1000 days", repository.findById(c.getId()).getName());
	}

	@Test
	void testPlayWithEntityManager() {
		repository.playWithEntityManager();
	}

	@Test
	void testJpql() {
		TypedQuery<Course> query = entityManager.createNamedQuery("query_get_all_courses", Course.class);

		List<Course> results = query.getResultList();

		logger.info("testJpql - result: {}", results);
	}

	@Test
	void testJpql_where() {
		TypedQuery<Course> query = entityManager.createNamedQuery("query_get_java_courses", Course.class);

		List<Course> results = query.getResultList();

		logger.info("testJpql_where - result: {}", results);
	}
}
