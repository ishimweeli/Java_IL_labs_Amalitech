package com.eliab.productcatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableEurekaClient
@EnableJpaRepositories
public class ProductCatalogServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductCatalogServiceApplication.class, args);
    }
}
