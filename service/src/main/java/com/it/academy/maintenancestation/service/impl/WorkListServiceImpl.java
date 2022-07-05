package com.it.academy.maintenancestation.service.impl;


import com.it.academy.maintenancestation.converter.WorkListConverter;
import com.it.academy.maintenancestation.dto.WorkListDto;
import com.it.academy.maintenancestation.entity.WorkList;
import com.it.academy.maintenancestation.repository.MechanicRepository;
import com.it.academy.maintenancestation.repository.WorkListRepository;
import com.it.academy.maintenancestation.service.WorkListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class WorkListServiceImpl
        implements WorkListService {

    @Resource
//    @Autowired
    private WorkListRepository workListRepository;

    @Resource
//    @Autowired
    private MechanicRepository mechanicRepository;

    @Resource
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
}
//    @Override
//    public WorkListDto addWorkList(WorkListDto workListDto) {
//        WorkList workList = new WorkList();
//        DtoToEntity(workListDto, workList);
//        WorkList savedWorkList = workListRepository.save(workList);
//        return EntityToDto(savedWorkList);
//    }
//
//    @Override
//    public WorkListDto updateWorkList(Integer idWorkList, WorkListDto workListDto) {
//        WorkList exportFromDBWorkList = workListRepository.getById(idWorkList);
//        exportFromDBWorkList.getMechanic().clear();
//        DtoToEntity(workListDto, exportFromDBWorkList);
//        WorkList savedWorkList = workListRepository.save(exportFromDBWorkList);
//        return EntityToDto(savedWorkList);
//    }
//
////    The deleteStudent() method fetches the existing student entity by passing the id.
////    We are calling the removeCourses() method of student entity to remove the existing courses before deleting the entity. This will delete the mapping record from the join table without deleting the course entity.
//    @Override
//    public String deleteWorkList(Integer idWorkList) {
//        Optional<WorkList> workList = workListRepository.findById(idWorkList);
//        if (workList.isPresent()) {
//            workList.get().removeMechanic();
//            workListRepository.deleteById(workList.get().getWorkListId());
//            return "workList with id:" + idWorkList + " deleted!";
//        }
//        return null;
//    }
//
//    private void DtoToEntity(WorkListDto workListDto, WorkList workList) {
//        workList.setWorkListName(workListDto.getWorkListName());
//        workList.setWorkListCoast(workListDto.getWorkListCoast());
//        if (workList.getMechanic() == null) {
//            workList.setMechanic(new HashSet<>());
//        }
//        workListDto.getMechanics().stream().forEach(nameMechanic -> {
//            Mechanic mechanic = mechanicRepository.findByName(nameMechanic);
//            if (mechanic == null) {
//                mechanic = new Mechanic();
//                mechanic.setWorkList(new HashSet<>());
//            }
//            mechanic.setMechanicName(nameMechanic);
//            workList.addMechanic(mechanic);
//        });
//    }
//
//    private WorkListDto EntityToDto(WorkList workList) {
//        WorkListDto responseWorkListDto = new WorkListDto();
//        responseWorkListDto.setWorkListId(workList.getWorkListId());
//        responseWorkListDto.setWorkListName(workList.getWorkListName());
//        responseWorkListDto.setMechanics(workList.getMechanic().stream().map(Mechanic::getMechanicName).collect(Collectors.toSet()));
//        return responseWorkListDto;
//    }


