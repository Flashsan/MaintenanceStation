package com.it.academy.maintenancestation.service.impl;

import com.it.academy.maintenancestation.converter.MapperConfiguration;
import com.it.academy.maintenancestation.dto.WorkListDto;
import com.it.academy.maintenancestation.entity.WorkList;
import com.it.academy.maintenancestation.repository.WorkListRepository;
import com.it.academy.maintenancestation.service.WorkListService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * WorkListService
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

@Service
@RequiredArgsConstructor
public class WorkListServiceImpl
        implements WorkListService {

    /**
     * WorkList repository.
     */
    private final WorkListRepository workListRepository;
    private final ModelMapper modelMapper;

    /**
     * service - show all workListDto
     *
     * @return all workListDto
     */
    @Override
    public List<WorkListDto> listAllWorkList() {
        List<WorkList> workList = workListRepository.findAll();
        return MapperConfiguration.convertList(workList, this::convertToWorkListDto);
    }

    /**
     * method -  find workList by id from db
     *
     * @param workListId
     * @return workListDto by id
     */
    @Override
    public WorkListDto findWorkListById(Integer workListId) {
        return convertToWorkListDto(workListRepository.findById(workListId).orElse(null));
    }

    /**
     * method - add workList in db
     *
     * @param workListDto
     */
    @Override
    public void addWorkList(WorkListDto workListDto) {
        workListRepository.save(convertDtoToEntityWorkList(workListDto));
    }

    /**
     * method - delete workList from db by id
     *
     * @param workListId
     */
    @Override
    public void deleteWorkListById(Integer workListId) {
        workListRepository.deleteById(workListId);
    }

    //entity to dto
    public WorkListDto convertToWorkListDto(WorkList workList) {
        WorkListDto workListDto = modelMapper.map(workList, WorkListDto.class);
        return workListDto;
    }
    //end entity to dto

    //dto to entity
    public WorkList convertDtoToEntityWorkList(WorkListDto workListDto) {
        WorkList workList = modelMapper.map(workListDto, WorkList.class);
        return workList;
    }
//end dto to entity

}




