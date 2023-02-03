package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.coonfig.annotation.CorsRegistry;
import org.springframework.web.servlet.coonfig.annotation.WebMvcConfigurer;


@SpringBootApplication
public class EnchereApplication {
    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                WebMvcConfigurer.super.addCorsMappings(registry);
                registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS").allowedOrigins("*").allowedMethods("*").allowedHeaders("*").maxAge(-1).allowCredentials(false);
            }
        };
    } 
    public static void main(String[] args) {
        SpringApplication.run(EnchereApplication.class, args);
    }
}
