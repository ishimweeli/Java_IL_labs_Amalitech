package com.amalitech.springboottodoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
public class SpringBootTodoAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTodoAppApplication.class, args);
    }

//    @Bean
//    public ViewResolver viewResolver() {
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setPrefix("classpath:/templates/");
//        viewResolver.setSuffix(".html");
//        return viewResolver;
//    }
}