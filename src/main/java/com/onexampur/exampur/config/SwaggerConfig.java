package com.onexampur.exampur.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig {

    @Bean
    public Docket postApi(){
//        return new Docket(DocumentationType.SWAGGER_2).groupName("xadmin").apiInfo(apiInfo()).
//                select().paths(regex("/api/user/")).build();
        return new Docket(DocumentationType.SWAGGER_2).groupName("User Login").apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.onexampur.exampur.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
       return new ApiInfoBuilder().title("User Component").version("3.0").
               contact(new Contact("Abhishek jaiswal","http://localhost:4200/","abhishekjais@gmail.com"))
               .description("This api is related to user ").build();
    }
}
