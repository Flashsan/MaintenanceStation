package com.it.academy.maintenancestation.service.impl;


import com.it.academy.maintenancestation.converter.MapperConfiguration;
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

    private final ModelMapper modelMapper;

    /**
     * SparePart repository.
     */
    private final SparePartRepository sparePartRepository;

    /**
     * service - show all sparePartDto
     *
     * @return all sparePartDto
     */

    @Override
    public List<SparePartDto> listAllSparePart() {
        List<SparePart> sparePartList = sparePartRepository.findAll();
        return MapperConfiguration.convertList(sparePartList, this::convertToSparePartDto);
    }

    /**
     * method -  find sparePart by id from db
     *
     * @param sparePartId
     * @return sparePartDto by id
     */
    @Override
    public SparePartDto findSparePartById(Integer sparePartId) {
        return convertToSparePartDto(sparePartRepository.findById(sparePartId).orElse(null));
    }

    /**
     * method - add sparePart in db
     *
     * @param sparePartDto
     */
    @Override
    public void addSparePart(SparePartDto sparePartDto) {
        sparePartRepository.save(convertDtoToEntitySparePart(sparePartDto));
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

    //entity to dto
    public SparePartDto convertToSparePartDto(SparePart sparePart) {
        SparePartDto sparePartDto = modelMapper.map(sparePart, SparePartDto.class);
        return sparePartDto;
    }
    //end entity to dto

    //dto to entity
    public SparePart convertDtoToEntitySparePart(SparePartDto sparePartDto) {
        SparePart sparePart = modelMapper.map(sparePartDto, SparePart.class);
        return sparePart;
    }

    public AdministratorDetails convertDtoToEntityAdministratorDetails(AdministratorDetailsDto administratorDetailsDto) {
        AdministratorDetails administratorDetails = modelMapper.map(administratorDetailsDto, AdministratorDetails.class);
        return administratorDetails;
    }
    //end dto to entity
}