package com.jpa.hibernate.app.repository;

import com.jpa.hibernate.app.AppApplication;
import com.jpa.hibernate.app.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
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
class NativeQueryTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	@Autowired
	CourseRepository repository;

	@Autowired
	EntityManager entityManager;

	@Test
	void testNativeQuery() {
		Query query = entityManager.createNativeQuery("SELECT * FROM  Course where id = ?", Course.class);
		query.setParameter(1, 10001L);
		List<Course> results = query.getResultList();
		logger.info("testJpql - result: {}", results);
	}

	@Test
	void testNativeQueryLike() {
		Query query = entityManager.createNativeQuery("SELECT * FROM  Course where name LIKE '%JAVA%'", Course.class);
		List<Course> results = query.getResultList();
		logger.info("testNativeQueryLike - result: {}", results);
	}

	@Test
	void nativeQueryToUpdate() {
		Query query = entityManager.createNativeQuery("Update Course set last_updated_date=sysdate()", Course.class);
		int result = query.executeUpdate();
		logger.info("nativeQueryToUpdate - result: {}", result);
	}

	@Test
	@Transactional
	void testNativeQueryWithNamedPAram() {
		Query query = entityManager.createNativeQuery("SELECT * FROM  Course where id = :id", Course.class);
		query.setParameter("id", 10001L);
		List<Course> results = query.getResultList();
		logger.info("testJpql - result: {}", results);
	}

}
