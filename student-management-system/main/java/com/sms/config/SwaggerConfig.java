package com.sms.config;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()

                // 🔐 Tell Swagger: we use JWT Bearer authentication
                .components(new Components()
                        .addSecuritySchemes("bearerAuth",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                        )
                )

                // 🔐 Apply security globally (all APIs)
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))

                // 📘 API info
                .info(new Info()
                        .title("Student Management System API")
                        .description("APIs for managing students, courses, attendance, and marks")
                        .version("1.0"));
    }
}
