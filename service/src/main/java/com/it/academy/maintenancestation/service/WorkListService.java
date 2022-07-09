package com.it.academy.maintenancestation.service;

import com.it.academy.maintenancestation.dto.WorkListDto;

import java.util.List;
import java.util.Optional;

public interface WorkListService {

    List<WorkListDto> listAllWorkList();

    WorkListDto findById(Integer workListId);

    void addWorkList(WorkListDto workListDto);

    void deleteWorkListById(Integer workListId);

}
