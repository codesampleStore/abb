package com.jpa.hibernate.app.controller;

import com.jpa.hibernate.app.entity.Passport;
import com.jpa.hibernate.app.entity.Student;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class StudentControllerTest {

  @Autowired
  private StudentController studentController;
  @MockBean
  private MockMvc mockMvc;

  @MockBean
  private StudentController mockController;

  @Autowired
  private WebApplicationContext webApplicationContext;

  @BeforeEach
  public void before() {
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
  }

  @Test
  void shouldFindStudentById() throws Exception {
    //Student s = studentController.getStudentById(20001L);
    //assertEquals(20001L, s.getId());
    Passport p = new Passport();
    p.setName("p1");
    Student student = new Student();
    student.setName("Marcin");
    student.setPassport(p);
    student.setGradeAvg(5.0);

    when(mockController.getStudentById(1L)).thenReturn(student);

    String json = mockMvc.perform(get("/student/1")
        .accept(MediaType.APPLICATION_JSON)
        .contentType(MediaType.APPLICATION_JSON))
        .andReturn().getResponse().getContentAsString();

    assertTrue(json.contains("\"name\":\"Marcin\""));

    mockMvc.perform(get("/student/1"))
        .andExpect(status().isOk());

    mockMvc.perform(get("/student/xxx"))
        .andExpect(status().is4xxClientError());
  }
}
