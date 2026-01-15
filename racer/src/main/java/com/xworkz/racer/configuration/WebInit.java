package com.xworkz.racer.configuration;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer  implements WebMvcConfigurer {


    @Override
    protected Class<?>[] getRootConfigClasses() {
        System.out.println("this is getRootConfigClasses");
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        System.out.println("this is getServletConfigClasses ");
        return new Class[]{WebConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        System.out.println("this is getServletMappings");
        return new String[]{"/"};
    }
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
        System.out.println("configureDefaultServletHandling");
        configurer.enable();
    }
}
