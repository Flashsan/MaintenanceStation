package com.it.academy.maintenancestation.service.impl;


import com.it.academy.maintenancestation.dto.AdministratorDto;
import com.it.academy.maintenancestation.entity.Administrator;
import com.it.academy.maintenancestation.repository.AdministratorRepository;
import com.it.academy.maintenancestation.service.AdministratorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
//@Transactional
//@Import(AdministratorRepository.class)
public class AdministratorServiceImpl
        implements AdministratorService {

    @Autowired
    private AdministratorRepository administratorRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<AdministratorDto> listAllAdministrators() {
        List<Administrator> administratorList =
                administratorRepository.findAll();
        return administratorList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Administrator findAdministratorById(Integer administratorId) {
        return administratorRepository.findById(administratorId).get();
    }


    @Override
    public void saveAdministrator(Administrator administrator) {
        administratorRepository.save(administrator);
    }

    @Override
    public void deleteAdministratorById(Integer administratorId) {
        administratorRepository.deleteById(administratorId);
    }

    private AdministratorDto convertToDto(Administrator administrator) {
        AdministratorDto administratorDto = modelMapper.map(administrator, AdministratorDto.class);
        return administratorDto;
    }
}
