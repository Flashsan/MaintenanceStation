package com.it.academy.maintenancestation.service.impl;


import com.it.academy.maintenancestation.converter.WorkListConverter;
import com.it.academy.maintenancestation.dto.WorkListDto;
import com.it.academy.maintenancestation.entity.WorkList;
import com.it.academy.maintenancestation.repository.MechanicRepository;
import com.it.academy.maintenancestation.repository.WorkListRepository;
import com.it.academy.maintenancestation.service.WorkListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
public class WorkListServiceImpl
        implements WorkListService {

    @Autowired
    private WorkListRepository workListRepository;

    @Autowired
    private WorkListConverter workListConverter;

    @Override
    public List<WorkListDto> listAllWorkList() {
        List<WorkList> exportFromDBWorkList =
                workListRepository.findAll();
        List<WorkListDto> workListDtos = new ArrayList<>();
        exportFromDBWorkList.stream()
                .forEach(workList -> {
                    WorkListDto workListDto = workListConverter.toDto(workList);
                    System.out.println(workListDto.toString());
                    workListDtos.add(workListDto);
                });
        return workListDtos;
    }

    @Override
    public WorkListDto findById(Integer workListId) {
        return workListConverter.toDto(
                workListRepository.findById(workListId).orElse(null));
    }

    @Override
    public void addWorkList(WorkListDto workListDto) {
        workListRepository.save(workListConverter.toEntity(workListDto));

    }

    @Override
    public void deleteWorkListById(Integer workListId) {
        workListRepository.deleteById(workListId);
    }

}




