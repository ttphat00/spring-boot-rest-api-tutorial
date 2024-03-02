package com.example.springrestapi.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringdocConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public-api")
                .pathsToMatch("/api/**")
                .build();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Cloud Vendor API Application")
                        .description("Cloud Vendor Documentation")
                        .version("1.0")
                        .license(new License()
                                    .name("My License")
                                    .url("http://example.com")))
                .externalDocs(new ExternalDocumentation()
                        .description("My External Documentation")
                        .url("https://my-external-doc-url.com"));
    }
}
