package com.it.academy.maintenancestation.service.impl;

import com.it.academy.maintenancestation.converter.impl.AdministratorMapper;
import com.it.academy.maintenancestation.dto.AdministratorDto;
import com.it.academy.maintenancestation.entity.Administrator;
import com.it.academy.maintenancestation.repository.AdministratorRepository;
import com.it.academy.maintenancestation.service.AdministratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * AdministratorService
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */
@Service
@Transactional
@RequiredArgsConstructor
public class AdministratorServiceImpl
        implements AdministratorService {

    private final AdministratorRepository administratorRepository;
    private final AdministratorMapper administratorMapper;

    /**
     * service - show all administratorsDto
     *
     * @return all administratorsDto
     */
    @Override
    public List<AdministratorDto> listAllAdministrators() {
        List<Administrator> administratorList =
                administratorRepository.findAll();
        return administratorList.stream()
                .map(administratorMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * method -  find administrator by id from db
     *
     * @param administratorId
     * @return administratorDto by id
     */
    @Override
    public AdministratorDto findAdministratorById(Integer administratorId) {
        return administratorMapper.toDto(
                administratorRepository.findById(administratorId).orElse(null));
    }

    /**
     * method - add administrator in db
     *
     * @param administratorDto
     */
    @Override
    public void addAdministrator(AdministratorDto administratorDto) {
        administratorRepository.save(administratorMapper.toEntity(administratorDto));
    }

    /**
     * method - delete administrator from db by id
     *
     * @param administratorId
     */
    @Override
    public void deleteAdministratorById(Integer administratorId) {
        administratorRepository.deleteById(administratorId);
    }
}
