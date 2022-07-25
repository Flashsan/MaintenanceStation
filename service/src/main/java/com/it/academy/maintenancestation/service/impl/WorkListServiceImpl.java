package com.it.academy.maintenancestation.service.impl;

import com.it.academy.maintenancestation.converter.MapperConfiguration;
import com.it.academy.maintenancestation.converter.impl.WorkListConverter;
import com.it.academy.maintenancestation.dto.MechanicDetailsDto;
import com.it.academy.maintenancestation.dto.MechanicDto;
import com.it.academy.maintenancestation.dto.SparePartDto;
import com.it.academy.maintenancestation.dto.WorkListDto;
import com.it.academy.maintenancestation.entity.Mechanic;
import com.it.academy.maintenancestation.entity.MechanicDetails;
import com.it.academy.maintenancestation.entity.SparePart;
import com.it.academy.maintenancestation.entity.WorkList;
import com.it.academy.maintenancestation.repository.WorkListRepository;
import com.it.academy.maintenancestation.service.WorkListService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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

    /**
     *
     */
    private final WorkListConverter workListConverter;

    /**
     * method return list with parameters
     *
     * @param pageNo
     * @param pageSize
     * @param sortField
     * @param sortDirection
     * @return
     */
    @Override
    public Page<WorkList> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return workListRepository.findAll(pageable);
    }

    /**
     * method -  find workList by id from db
     *
     * @param workListId
     * @return workListDto by id
     */
    @Override
    public WorkListDto findWorkListById(Integer workListId) {
        return workListConverter.entityToDto(workListRepository.findById(workListId).orElse(null));
    }

    /**
     * method - add workList in db
     *
     * @param workListDto
     */
    @Override
    public void addWorkList(WorkListDto workListDto) {
        workListRepository.save(workListConverter.dtoToEntity(workListDto));
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

}




