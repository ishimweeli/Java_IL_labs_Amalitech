package com.eliab.currencyconverter.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info =
@Info(title = "My API", version = "3.0", description = "My awesome API documentation")
)

public class SwaggerConfig {

}
