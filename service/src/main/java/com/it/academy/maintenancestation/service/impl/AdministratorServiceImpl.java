package com.it.academy.maintenancestation.service.impl;

import com.it.academy.maintenancestation.converter.AdministratorConverter;
import com.it.academy.maintenancestation.dto.AdministratorDto;
import com.it.academy.maintenancestation.entity.Administrator;
import com.it.academy.maintenancestation.repository.AdministratorRepository;
import com.it.academy.maintenancestation.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AdministratorServiceImpl
        implements AdministratorService {

    @Autowired
    private AdministratorRepository administratorRepository;

    @Autowired
    private AdministratorConverter administratorConverter;

    @Override
    public List<AdministratorDto> listAllAdministrators() {
        List<Administrator> administratorList =
                administratorRepository.findAll();
        return administratorList.stream()
                .map(administratorConverter::toDto)
                .collect(Collectors.toList());
    }
}
//
//    @Override
//    public Administrator findAdministratorById(Integer administratorId) {
//        return administratorRepository.findById(administratorId).get();
//    }
//
//    @Override
//    public void newAdministrator(AdministratorDto administratorDto) {
//        administratorRepository.save(administratorConverter.toEntity(administratorDto));
//    }
//
//    @Override
//    public void deleteAdministratorById(Integer administratorId) {
//        administratorRepository.deleteById(administratorId);
//    }

