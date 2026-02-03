package com.xworkz.sports.configuration;


import org.springframework.context.annotation.Configuration;



import org.springframework.context.annotation.ComponentScan;

@Configuration
@ComponentScan("com.xworkz.games")
public class WebConfiguration {


    public WebConfiguration() {

        System.out.println("this is WebConfiguration class");
    }

}

