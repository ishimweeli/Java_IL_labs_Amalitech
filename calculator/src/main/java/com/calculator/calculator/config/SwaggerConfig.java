package com.calculator.calculator.config;

import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(info =
@Info(title = "My API", version = "3.0", description = "My awesome API documentation")
)

public class SwaggerConfig {
    // Additional configuration if needed
}
