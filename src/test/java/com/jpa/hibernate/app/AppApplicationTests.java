package com.jpa.hibernate.app;

import org.hibernate.resource.beans.container.internal.NoSuchBeanException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AppApplicationTests {

	@Autowired
	private ApplicationContext context; //eager, BeanFactor is lazy
	@Test
	void contextLoads() {
		int count = context.getBeanDefinitionCount();
		System.out.println("There are are: "+count+ " beans");

		Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
	}

	@Test @Disabled
	void getBeanTest() {
		assertThrows(org.springframework.beans.factory.NoSuchBeanDefinitionException.class,
				() -> context.getBean(RestTemplate.class));
	}

}
