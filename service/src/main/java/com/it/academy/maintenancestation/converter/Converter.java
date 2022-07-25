package com.it.academy.maintenancestation.converter;

public interface Converter<E,D> {

    D entityToDto(E entity);

    E dtoToEntity(D dto);
}
