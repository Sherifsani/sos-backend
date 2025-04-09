package com.example.sosbackend;

import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;

@Configuration
public class SwaggerConfig {

  @Bean
  public OpenAPI sosbackendOpenAPI() {
    return new OpenAPI()
        .info(new Info().title("Sos Backend Api Documentation")
            .description("API documentation for sos backend"));
  }
}
