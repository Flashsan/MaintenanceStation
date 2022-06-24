package com.it.academy.maintenancestation;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Converter {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
