package com.it.academy.maintenancestation.converter;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Mapper Configuration
 *
 * @version 12.07.2022
 */

@Configuration
public class MapperConfiguration {

    /**
     *
     * @return
     */
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    /**
     *
     * @param list
     * @param converter
     * @param <R>
     * @param <E>
     * @return
     */
    public static <R, E> List<R> convertList(List<E> list, Function<E, R> converter) {
        return list.stream().map(e -> converter.apply(e)).collect(Collectors.toList());
    }
}
