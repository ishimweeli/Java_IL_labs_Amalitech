package com.onlineExamination.userService;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class UserServiceApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// Disable default static resource handling
		servletContext.setInitParameter("spring.resources.add-mappings", "false");
		super.onStartup(servletContext);
	}
}