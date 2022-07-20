package com.it.academy.maintenancestation.service.impl;

import com.it.academy.maintenancestation.converter.MapperConfiguration;
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
    private final ModelMapper modelMapper;


    /**
     * service - show all workListDto
     *
     * @return all workListDto
     */
    @Override
    public List<WorkListDto> listAllWorkList(int pageNo, int pageSize, String sortField, String sortDir) {

        Page<WorkList> page = findPaginated(pageNo, pageSize, sortField, sortDir);
        List<WorkList> workList = page.getContent();
        return MapperConfiguration.convertList(workList, this::convertToWorkListDto);
    }

    private Page<WorkList> findPaginated(int pageNo, int pageSize, String sortField, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize,sort);
        return this.workListRepository.findAll(pageable);
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
        List<MechanicDto> mechanicDto = workListDto.getMechanic();
//        List<SparePartDto> sparePartDto = workListDto.getSparePart();

        List<Mechanic> mechanics = mechanicDto.stream()
                .map(this::convertDtoToEntityMechanic)
                .collect(Collectors.toList());

//        List<SparePart> spareParts = sparePartDto.stream()
//                .map(this::convertDtoToEntitySparePart)
//                .collect(Collectors.toList());

        workList.setMechanic(mechanics);
//        workList.setSparePart(spareParts);

        return workList;
    }
//end dto to entity

    //dto to entity
    public Mechanic convertDtoToEntityMechanic(MechanicDto mechanicDto) {
        Mechanic mechanic = modelMapper.map(mechanicDto, Mechanic.class);
        MechanicDetails mechanicDetails = convertDtoToEntityMechanicDetails(mechanicDto.getMechanicDetails());
        mechanic.setMechanicDetails(mechanicDetails);
        mechanicDetails.setMechanic(mechanic);
        mechanicDetails.setMechanicDetailsId(mechanic.getMechanicId());
        return mechanic;
    }

    public MechanicDetails convertDtoToEntityMechanicDetails(MechanicDetailsDto mechanicDetailsDto) {
        MechanicDetails mechanicDetails = modelMapper.map(mechanicDetailsDto, MechanicDetails.class);
        return mechanicDetails;
    }


    //dto to entity
    public SparePart convertDtoToEntitySparePart(SparePartDto sparePartDto) {
        SparePart sparePart = modelMapper.map(sparePartDto, SparePart.class);
        return sparePart;
    }

}




