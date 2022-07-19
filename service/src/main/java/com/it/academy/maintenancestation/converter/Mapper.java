package com.it.academy.maintenancestation.converter;

public interface Mapper<E,D> {

    E dtoToEntity(D dto);

    D entityToDto(E entity);
}
