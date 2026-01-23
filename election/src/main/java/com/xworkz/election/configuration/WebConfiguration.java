package com.xworkz.election.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class WebConfiguration {

    @Configuration
    @ComponentScan("com.xworkz.election")
    public class WebConfigutation {


        public WebConfigutation() {

            System.out.println("this is webconfiguration");
        }

        @Bean
        public ViewResolver ViewReslover() {
            return new InternalResourceViewResolver("/", ".jsp");
        }
    }
}
