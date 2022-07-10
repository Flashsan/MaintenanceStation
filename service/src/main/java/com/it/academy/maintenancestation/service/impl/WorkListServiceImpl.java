package com.it.academy.maintenancestation.service.impl;


import com.it.academy.maintenancestation.converter.WorkListConverter;
import com.it.academy.maintenancestation.dto.WorkListDto;
import com.it.academy.maintenancestation.entity.WorkList;
import com.it.academy.maintenancestation.pagination.Paged;
import com.it.academy.maintenancestation.pagination.Paging;
import com.it.academy.maintenancestation.repository.WorkListRepository;
import com.it.academy.maintenancestation.service.WorkListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class WorkListServiceImpl
        implements WorkListService {

    @Autowired
    private WorkListRepository workListRepository;

    @Autowired
    private WorkListConverter workListConverter;

    @Override
    public Paged<WorkList> getPage(int pageNumber, int size) {
        PageRequest request = PageRequest.of(pageNumber - 1, size,Sort.unsorted());
        Page<WorkList> workListPage = workListRepository.findAll(request);
        Page<WorkListDto> workListDtoPage = (Page<WorkListDto>) workListPage.stream()
                .map(workListConverter::toDto)
                .collect(Collectors.toList());
        return new Paged<>(workListPage, Paging.of(workListPage.getTotalPages(), pageNumber, size));
    }

    @Override
    public List<WorkListDto> listAllWorkList() {
        List<WorkList> exportFromDBWorkList =
                workListRepository.findAll();
        List<WorkListDto> workListDtos = new ArrayList<>();
        exportFromDBWorkList.stream()
                .forEach(workList -> {
                    WorkListDto workListDto = workListConverter.toDto(workList);
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




