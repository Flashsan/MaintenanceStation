package com.it.academy.maintenancestation.securingWeb;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry viewControllerRegistry){
//        viewControllerRegistry.addViewController("/home").setViewName("home");
//        viewControllerRegistry.addViewController("/").setViewName("home");
//        viewControllerRegistry.addViewController("/hello").setViewName("hello");
//        viewControllerRegistry.addViewController("/login").setViewName("login");
    }

}
