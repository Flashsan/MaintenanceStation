package com.it.academy.maintenancestation.converter;

/**
 * Converter interface
 *
 * @param <E>
 * @param <D> * @author Alexander Grigorovich
 * @version 12.07.2022
 */

public interface Converter<E, D> {

    /**
     *
     * @param entity
     * @return
     */
    D entityToDto(E entity);

    /**
     *
     * @param dto
     * @return
     */
    E dtoToEntity(D dto);
}
