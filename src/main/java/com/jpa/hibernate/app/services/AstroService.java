package com.jpa.hibernate.app.services;

import com.jpa.hibernate.app.json.AstroResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class AstroService {

  private final WebClient client;
  private final RestTemplate template;

  public AstroService(@Qualifier("astroRestTemplate") RestTemplate template) {

    this.template = template;
    this.client = WebClient.create("http://api.open-notify.org");
  }

  public String getPeopleInSpace() {
    return this.template.getForObject("/astros.json", String.class);
  }

  public AstroResponse getAstroResponse() {
    return this.template.getForObject("/astros.json", AstroResponse.class);
  }

  public AstroResponse getAstroResponseAsync() {
    return client.get()
        .uri("/astros.json")
        .accept(MediaType.APPLICATION_JSON)
        .retrieve()
        .bodyToMono(AstroResponse.class)
        .block();
  }

}
