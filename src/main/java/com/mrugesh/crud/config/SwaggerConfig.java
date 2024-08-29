package com.mrugesh.crud.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {
//
//    @Value("{mrugesh.swagger.dev-url}")
//    private String devUrl;
//
//    @Value("{mrugesh.swagger.prod-url}")
//    private String prodUrl;

    @Bean
    public OpenAPI myOpenAPI(){
//        Server devServer = new Server();
//        devServer.setUrl(devUrl);
//        devServer.setDescription("Server Url in Development Environment");

//        Server prodServer = new Server();
//        prodServer.setUrl(prodUrl);
//        prodServer.setDescription("Server Url in Production Environment");

        Contact contact = new Contact();
        contact.setEmail("mrugeshrlimbachiya@gmail.com");
        contact.setName("Mrugesh");
        contact.setUrl("https://www.mrugesh.com");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("Employee Management API")
                .version("1.0")
                .contact(contact)
                .description("This API is use to Expose Endpoints to manage Employees")
                .termsOfService("https://www.mrugesh.com/terms")
                .license(mitLicense);

        return new OpenAPI().info(info)/*.servers(List.of(devServer, prodServer))*/;
    }
}
