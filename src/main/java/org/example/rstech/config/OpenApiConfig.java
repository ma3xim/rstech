package org.example.rstech.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class OpenApiConfig {
    //@Bean
    public OpenAPI api() {
        return new OpenAPI().info(new Info().title("Product Catalog API").version("v1").description("REST API для каталога продуктов"));
    }
}

