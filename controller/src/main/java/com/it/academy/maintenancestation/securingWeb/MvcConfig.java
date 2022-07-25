package com.it.academy.maintenancestation.securingWeb;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * MvcConfig RestController
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /**
     *
     */
    public static final String MAIN = "main";

    /**
     *
     */
    public static final String LOGIN = "login";

    /**
     * @param viewControllerRegistry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry viewControllerRegistry) {
        viewControllerRegistry.addViewController("/").setViewName(MAIN);
        viewControllerRegistry.addViewController("/login").setViewName(LOGIN);
    }
}
