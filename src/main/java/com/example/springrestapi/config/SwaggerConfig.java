/*
package com.example.springrestapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket swaggerConfiguration(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.any()) //.paths(PathSelectors.ant("/api/cloud-vendor/*"))
                .apis(RequestHandlerSelectors.basePackage("com.example.springrestapi"))
                .build()
                .apiInfo(apiCustomData());
    }

    private ApiInfo apiCustomData(){
        return new ApiInfo(
                "Cloud Vendor API Application",
                "Cloud Vendor Documentation",
                "1.0",
                "Cloud Vendor Service Terms",
                new Contact("Phat Tran", "http://example.com", "phat@gmail.com"),
                "My License",
                "http://example.com",
                Collections.emptyList()
        );
    }
}
*/
