package com.it.academy.maintenancestation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication
@ComponentScan(basePackages = {"com.it.academy.maintenancestation.*"})
@EntityScan(basePackages = {"com.it.academy.maintenancestation.*"})
@EnableJpaRepositories(basePackages = {"com.it.academy.maintenancestation.*"} )
public class MaintenanceStationApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaintenanceStationApplication.class, args);
    }

}
