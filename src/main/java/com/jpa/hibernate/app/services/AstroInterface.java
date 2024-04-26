package com.jpa.hibernate.app.services;

import com.jpa.hibernate.app.json.AstroResponse;
import org.springframework.web.service.annotation.GetExchange;

public interface AstroInterface {

  @GetExchange("/astros.json")
  AstroResponse getResponse();

}
