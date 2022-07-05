package com.it.academy.maintenancestation.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Objects;


public class AbstractConverter<E, D> implements Converter<E, D> {

    @Autowired
    ModelMapper modelMapper;

    private Class<E> entityClass;
    private Class<D> dtoClass;

    public AbstractConverter(Class<E> entityClass,
                             Class<D> dtoClass) {
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
    }

    @Override
    public E toEntity(D dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, entityClass);
    }

    @Override
    public D toDto(E entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, dtoClass);
    }


}
