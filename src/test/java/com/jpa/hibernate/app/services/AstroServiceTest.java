package com.jpa.hibernate.app.services;

import com.jpa.hibernate.app.json.AstroResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AstroServiceTest {

  @Autowired
  private AstroService service;

  @Test
  void testGetPeopleInSpace() {
    String str = service.getPeopleInSpace();
    assertTrue(str.contains("success"));
    System.out.println(str);
  }

  @Test
  void testGetAstroResponse() {
    AstroResponse response = service.getAstroResponse();
    assertTrue(response.people().size()>0);
    System.out.println(response);
  }

  @Test
  void testGetAstroResponseAsync() {
    AstroResponse response = service.getAstroResponseAsync();
    assertTrue(response.people().size()>0);
    System.out.println(response);
  }
}