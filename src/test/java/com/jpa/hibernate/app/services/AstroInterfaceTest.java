package com.jpa.hibernate.app.services;

import com.jpa.hibernate.app.json.AstroResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AstroInterfaceTest {

  @Autowired
  private AstroInterface astroInterface;

  @Test
  void getResponse() {
    AstroResponse response = astroInterface.getResponse();
    assertTrue(response.message().contains("success"));
    System.out.printf("RESPONSE: %s%n",response);
  }
}