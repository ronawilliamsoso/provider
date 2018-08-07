package com.vcg.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-26T05:18:18.898Z")

@Configuration
public class SwaggerDocumentationConfig {

    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("provider service 2.0相关接口")
            .description("provider service 2.0相关接口")
            .license("VCG 2.0")
            .licenseUrl("http://www.vcg.com")
            .termsOfServiceUrl("")
            .version("1.0")
            //.contact(new Contact("李真河","", "zhenhe.li@vcg.com"))
            .build();
    }

    @Bean
    public Docket customImplementation(){
    	Set<String> protocols = new HashSet<String>();
    	protocols.add("http");
    	
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                    .apis(RequestHandlerSelectors.basePackage("com.vcg"))
                    .build()
                .directModelSubstitute(org.joda.time.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(org.joda.time.DateTime.class, java.util.Date.class)
                .apiInfo(apiInfo())
                .protocols(protocols);
    }

}
