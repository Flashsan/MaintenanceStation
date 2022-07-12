package com.it.academy.maintenancestation.service;

import com.it.academy.maintenancestation.dto.WorkListDto;
import com.it.academy.maintenancestation.entity.WorkList;

import javax.validation.Valid;
import java.util.List;

public interface WorkListService {

//    public Paged<WorkList> getPage(int pageNumber, int size);

    List<WorkListDto> listAllWorkList();

//    WorkListDto findById(Integer workListId);
//
    void addWorkList(@Valid WorkList workListDto);

//
//    void deleteWorkListById(Integer workListId);

}
