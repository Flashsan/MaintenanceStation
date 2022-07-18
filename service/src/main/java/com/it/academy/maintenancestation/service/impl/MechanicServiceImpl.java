package com.it.academy.maintenancestation.service.impl;


import com.it.academy.maintenancestation.converter.MapperConfiguration;
import com.it.academy.maintenancestation.dto.ClientDetailsDto;
import com.it.academy.maintenancestation.dto.ClientDto;
import com.it.academy.maintenancestation.dto.MechanicDetailsDto;
import com.it.academy.maintenancestation.dto.MechanicDto;
import com.it.academy.maintenancestation.entity.Client;
import com.it.academy.maintenancestation.entity.ClientDetails;
import com.it.academy.maintenancestation.entity.Mechanic;
import com.it.academy.maintenancestation.entity.MechanicDetails;
import com.it.academy.maintenancestation.repository.ClientRepository;
import com.it.academy.maintenancestation.repository.MechanicRepository;
import com.it.academy.maintenancestation.service.MechanicService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MechanicServiceImpl
        implements MechanicService {

    ModelMapper modelMapper = new ModelMapper();

    /**
     * Mechanic repository.
     */
    private final MechanicRepository mechanicRepository;

    /**
     * service - show all mechanicDto
     *
     * @return all mechanicDto
     */
    @Override
    public List<MechanicDto> listAllMechanics() {
        List<Mechanic> mechanicList = mechanicRepository.findAll();
        return MapperConfiguration.convertList(mechanicList, this::convertToMechanicDto);
    }

    /**
     * method -  find mechanic by id from db
     *
     * @param mechanicId
     * @return mechanicDto by id
     */
    @Override
    public MechanicDto findMechanicById(Integer mechanicId) {
        return convertToMechanicDto(mechanicRepository.findById(mechanicId).orElse(null));
    }

    /**
     * method - add mechanic in db
     *
     * @param mechanicDto
     */
    @Override
    public void addMechanic(MechanicDto mechanicDto) {
        mechanicRepository.save(convertDtoToEntityMechanic(mechanicDto));
    }

    /**
     * method - delete mechanic from db by id
     *
     * @param mechanicId
     */
    @Override
    public void deleteMechanicById(Integer mechanicId) {
        mechanicRepository.deleteById(mechanicId);
    }

    //entity to dto
    public MechanicDto convertToMechanicDto(Mechanic mechanic) {
        MechanicDto mechanicDto = modelMapper.map(mechanic, MechanicDto.class);
        mechanicDto.setMechanicDetails(convertToMechanicDetailsDto(mechanic.getMechanicDetails()));
        return mechanicDto;
    }

    public MechanicDetailsDto convertToMechanicDetailsDto(MechanicDetails mechanicDetails) {
        MechanicDetailsDto mechanicDetailsDto = modelMapper.map(mechanicDetails, MechanicDetailsDto.class);
        return mechanicDetailsDto;
    }
    //end entity to dto

    //dto to entity
    public Mechanic convertDtoToEntityMechanic(MechanicDto mechanicDto) {
        Mechanic mechanic = modelMapper.map(mechanicDto, Mechanic.class);
        MechanicDetails mechanicDetails = convertDtoToEntityMechanicDetails(mechanicDto.getMechanicDetails());
        mechanic.setMechanicDetails(mechanicDetails);
        mechanicDetails.setMechanic(mechanic);
        mechanicDetails.setMechanicDetailsId(mechanic.getMechanicId());
        return mechanic;
    }

    public MechanicDetails convertDtoToEntityMechanicDetails(MechanicDetailsDto mechanicDetailsDto) {
        MechanicDetails mechanicDetails = modelMapper.map(mechanicDetailsDto, MechanicDetails.class);
        return mechanicDetails;
    }
    //end dto to entity

}
