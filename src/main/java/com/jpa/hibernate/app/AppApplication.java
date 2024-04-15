package com.jpa.hibernate.app;

import com.jpa.hibernate.app.entity.Course;
import com.jpa.hibernate.app.repository.CourseRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {
	Logger logger = LogManager.getLogger(AppApplication.class);
	@Autowired
	private CourseRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Course course = repository.findById(10001L);
		logger.info("Course with ID 10001 is: {}", course);
		//repository.deleteById(10001L);
		//logger.info("Course with ID 10001 is: {}", repository.findById(10001L));
		logger.info("Created new course: {}", repository.save(new Course("MicroServices in 100 steps")));
	}
}
