package com.it.academy.maintenancestation.converter;

public interface Mapper<E,D> {

    E toEntity(D dto);

    D toDto(E entity);
}
