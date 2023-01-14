package com.sa.tav.cinema.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CinemaConfig implements WebMvcConfigurer {

    @Value("${cors.url}")
    private String url;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(url)
                .allowedMethods("GET, POST, PUT, DELETE")
                .allowedHeaders("*")
                .allowCredentials(false)
                .maxAge(3600);
    }


}
