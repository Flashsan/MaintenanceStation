package com.it.academy.maintenancestation.converter.impl;

import com.it.academy.maintenancestation.converter.Mapper;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Objects;


public abstract class AbstractMapper<E, D> implements Mapper<E, D> {

    @Autowired
    ModelMapper modelMapper;

    private Class<E> entityClass;
    private Class<D> dtoClass;

    public AbstractMapper(Class<E> entityClass,
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
