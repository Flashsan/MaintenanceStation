package com.it.academy.maintenancestation.service;

import com.it.academy.maintenancestation.dto.WorkListDto;
import com.it.academy.maintenancestation.entity.WorkList;
import com.it.academy.maintenancestation.pagination.Paged;

import java.util.List;
import java.util.Optional;

public interface WorkListService {

    public Paged<WorkList> getPage(int pageNumber, int size);

    List<WorkListDto> listAllWorkList();

    WorkListDto findById(Integer workListId);

    void addWorkList(WorkListDto workListDto);

    void deleteWorkListById(Integer workListId);

}
