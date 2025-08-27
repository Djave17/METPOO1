package com.demo.backend;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/** Habilita CORS para Angular en localhost (5173 o 4200). No guardamos estado en ningún lado. */
@Configuration
public class Config implements WebMvcConfigurer {
  @Override public void addCorsMappings(CorsRegistry reg) {
    reg.addMapping("/api/**")
       .allowedOrigins("http://localhost:5173", "http://localhost:4200")
       .allowedMethods("GET","POST");
  }
}
