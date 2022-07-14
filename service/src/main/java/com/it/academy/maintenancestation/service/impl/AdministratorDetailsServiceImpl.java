package com.it.academy.maintenancestation.service.impl;

import com.it.academy.maintenancestation.converter.MapperConfiguration;
import com.it.academy.maintenancestation.converter.impl.AdministratorDetailsMapper;
import com.it.academy.maintenancestation.converter.impl.AdministratorMapper;
import com.it.academy.maintenancestation.dto.AdministratorDetailsDto;
import com.it.academy.maintenancestation.dto.AdministratorDto;
import com.it.academy.maintenancestation.entity.Administrator;
import com.it.academy.maintenancestation.entity.AdministratorDetails;
import com.it.academy.maintenancestation.repository.AdministratorDetailsRepository;
import com.it.academy.maintenancestation.repository.AdministratorRepository;
import com.it.academy.maintenancestation.service.AdministratorDetailsService;
import com.it.academy.maintenancestation.service.AdministratorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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
public class AdministratorDetailsServiceImpl implements AdministratorDetailsService {

    private final AdministratorDetailsRepository administratorDetailsRepository;
    private final AdministratorDetailsMapper administratorDetailsMapper;

    /**
     * service - show all administratorsDetailsDto
     *
     * @return all administratorsDto
     */
    @Override
    public List<AdministratorDetailsDto> listAllAdministratorDetails() {
        List<AdministratorDetails> administratorDetailsList = administratorDetailsRepository.findAll();
//        return administratorDetailsList.stream().map(this::convertToAdministratorDetailsDto).collect(Collectors.toList());
        return null;
    }

    /**
     * method -  find administratorDetails by administratorDetailsId from db
     *
     * @param administratorDetailsId
     * @return administratorDetailsDto by administratorDetailsId
     */
    @Override
    public AdministratorDetailsDto findAdministratorDetailsById(Integer administratorDetailsId) {
        return convertToAdministratorDetailsDto(
                administratorDetailsRepository
                        .findById(administratorDetailsId)
                        .orElse(null));

    }

    /**
     * method - add administrator details in db
     *
     * @param administratorDetailsDto
     */
    @Override
    public void addAdministratorDetails(AdministratorDetailsDto administratorDetailsDto) {
        administratorDetailsRepository.save(administratorDetailsMapper.toEntity(administratorDetailsDto));
    }

    /**
     * method - delete administrator details from db by administratorDetailsId
     *
     * @param administratorDetailsId
     */
    @Override
    public void deleteAdministratorDetailsById(Integer administratorDetailsId) {
        administratorDetailsRepository.deleteById(administratorDetailsId);
    }


    ModelMapper modelMapper = new ModelMapper();

    public AdministratorDetailsDto convertToAdministratorDetailsDto(AdministratorDetails administratorDetails) {
        AdministratorDetailsDto administratorDetailsDto = modelMapper.map(administratorDetails, AdministratorDetailsDto.class);
        return administratorDetailsDto;
    }

}
