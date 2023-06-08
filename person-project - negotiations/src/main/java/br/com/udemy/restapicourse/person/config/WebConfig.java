package br.com.udemy.restapicourse.person.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        
        final MediaType MEDIA_TYPE_APPLICATION_YAML = MediaType.valueOf("application/x-yaml");

        //Via Query params
        // configurer.favorParameter(true)
        //     .parameterName("mediaType")
        //     .ignoreAcceptHeader(true)
        //     .useRegisteredExtensionsOnly(false)
        //     .defaultContentType(MediaType.APPLICATION_JSON)
        //     .mediaType("json",MediaType.APPLICATION_JSON)
        //     .mediaType("xml", MediaType.APPLICATION_XML);

        //via Header params


        configurer.favorParameter(false)
            .ignoreAcceptHeader(false)
            .useRegisteredExtensionsOnly(false)
            .defaultContentType(MediaType.APPLICATION_JSON)
            .mediaType("json",MediaType.APPLICATION_JSON)
            .mediaType("xml", MediaType.APPLICATION_XML)
            .mediaType("x-yaml", MEDIA_TYPE_APPLICATION_YAML)
            ;
    }
    
}
