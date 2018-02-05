package com.example.server;

import com.example.server.DAO.ProductDaoImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class ServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);

        //ProductDaoImpl.getInstance().getAll().forEach(System.out::println);
        //ProductDaoImpl.getInstance().getInStock().forEach(System.out::println);
        //ProductDaoImpl.getInstance().getTopFive().forEach(System.out::println);
        ProductDaoImpl.getInstance().searchProduct("road").forEach(System.out::println);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/get_top_five").allowedOrigins("*");
            }
        };
    }
}

