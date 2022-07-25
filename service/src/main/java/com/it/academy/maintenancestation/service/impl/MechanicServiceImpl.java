package com.it.academy.maintenancestation.service.impl;

import com.it.academy.maintenancestation.converter.MapperConfiguration;
import com.it.academy.maintenancestation.converter.impl.MechanicConverter;
import com.it.academy.maintenancestation.converter.impl.WorkListConverter;
import com.it.academy.maintenancestation.dto.*;
import com.it.academy.maintenancestation.entity.*;
import com.it.academy.maintenancestation.repository.MechanicRepository;
import com.it.academy.maintenancestation.service.MechanicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * MechanicService
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

@Service
@RequiredArgsConstructor
public class MechanicServiceImpl
        implements MechanicService {

    /**
     * Mechanic repository.
     */
    private final MechanicRepository mechanicRepository;

    /**
     *
     */
    private final MechanicConverter mechanicConverter;

    /**
     *
     */
    private final WorkListConverter workListConverter;

    /**
     * service - show all mechanicDto
     *
     * @return all mechanicDto
     */
    @Override
    public List<MechanicDto> listAllMechanics() {
        List<Mechanic> mechanicList = mechanicRepository.findAll();
        return MapperConfiguration.convertList(mechanicList, mechanicConverter::entityToDto);
    }

    /**
     * method -  find mechanic by id from db
     *
     * @param mechanicId
     * @return mechanicDto by id
     */
    @Override
    public MechanicDto findMechanicById(Integer mechanicId) {
        return mechanicConverter.entityToDto(mechanicRepository.findById(mechanicId).orElse(null));
    }

    /**
     * method - add mechanic in db
     *
     * @param mechanicDto
     */
    @Override
    public void addMechanic(MechanicDto mechanicDto) {
        mechanicRepository.save(mechanicConverter.dtoToEntity(mechanicDto));
    }

    /**
     * method - delete mechanic from db by id
     *
     * @param mechanicId
     */
    @Override
    public void deleteMechanicById(Integer mechanicId) {
        mechanicRepository.deleteById(mechanicId);
    }

    /**
     * method - show list pinned workList
     *
     * @param byMechanicId
     * @return list
     */
    @Override
    public List<WorkListDto> listPinnedWorkList(Integer byMechanicId) {
        List<WorkList> workListList = mechanicRepository.getMechanicTask(byMechanicId);
        return workListList.stream()
                .map(workListConverter::entityToDto)
                .collect(Collectors.toList());
    }

}
