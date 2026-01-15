package com.xworkz.racer.configuration;

import com.xworkz.racer.dto.RacerDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.xworkz.racer")
public class WebConfiguration {
    public WebConfiguration() {
        System.out.println("this is WebConfiguration.class");
        System.out.println("th");
    }
    @Bean
    public String dto() {
        System.out.println("this is String register");
        return new String();
    }

}
