package com.jpa.hibernate.app.config;

import com.jpa.hibernate.app.services.AstroInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class AppConfig {

  @Bean
  public RestTemplate astroRestTemplate(RestTemplateBuilder builder, @Value("${astro.baseUrl}") String baseUrl) {
    return builder
        .rootUri(baseUrl)
        .build();
  }

  @Bean
  public RestTemplate anotherAstroRestTemplate(RestTemplateBuilder builder, @Value("${astro.baseUrl}") String baseUrl) {
    return builder
        .rootUri(baseUrl)
        .build();
  }

  @Bean
  public AstroInterface astroInterface( @Value("${astro.baseUrl}") String baseUrl) {
    WebClient client = WebClient.create(baseUrl);

    HttpServiceProxyFactory factory =
        HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build();

    return factory.createClient(AstroInterface.class);
  }
}
