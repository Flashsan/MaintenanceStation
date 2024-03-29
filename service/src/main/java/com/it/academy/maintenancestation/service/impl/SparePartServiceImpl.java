package com.it.academy.maintenancestation.service.impl;


import com.it.academy.maintenancestation.converter.MapperConfiguration;
import com.it.academy.maintenancestation.converter.impl.SparePartConverter;
import com.it.academy.maintenancestation.dto.AdministratorDetailsDto;
import com.it.academy.maintenancestation.dto.SparePartDto;
import com.it.academy.maintenancestation.entity.AdministratorDetails;
import com.it.academy.maintenancestation.entity.SparePart;
import com.it.academy.maintenancestation.repository.SparePartRepository;
import com.it.academy.maintenancestation.service.SparePartService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SparePartService
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

@Service
@RequiredArgsConstructor
public class SparePartServiceImpl
        implements SparePartService {

    /**
     * SparePart repository.
     */
    private final SparePartRepository sparePartRepository;

    /**
     *
     */
    private final SparePartConverter sparePartConverter;

    /**
     * service - show all sparePartDto
     *
     * @return all sparePartDto
     */

    @Override
    public List<SparePartDto> listAllSparePart() {
        List<SparePart> sparePartList = sparePartRepository.findAll();
        return MapperConfiguration.convertList(sparePartList, sparePartConverter::entityToDto);
    }

    /**
     * method -  find sparePart by id from db
     *
     * @param sparePartId
     * @return sparePartDto by id
     */
    @Override
    public SparePartDto findSparePartById(Integer sparePartId) {
        return sparePartConverter.entityToDto(sparePartRepository.findById(sparePartId).orElse(null));
    }

    /**
     * method - add sparePart in db
     *
     * @param sparePartDto
     */
    @Override
    public void addSparePart(SparePartDto sparePartDto) {
        sparePartRepository.save(sparePartConverter.dtoToEntity(sparePartDto));
    }

    /**
     * method - delete sparePart from db by id
     *
     * @param sparePartId
     */
    @Override
    public void deleteSparePartById(Integer sparePartId) {
        sparePartRepository.deleteById(sparePartId);
    }

}