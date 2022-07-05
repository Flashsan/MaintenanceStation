package com.it.academy.maintenancestation.service.impl;


import com.it.academy.maintenancestation.converter.MechanicConverter;
import com.it.academy.maintenancestation.dto.MechanicDto;
import com.it.academy.maintenancestation.entity.Mechanic;
import com.it.academy.maintenancestation.repository.MechanicRepository;
import com.it.academy.maintenancestation.service.MechanicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MechanicServiceImpl
        implements MechanicService {


    @Autowired
    private MechanicRepository mechanicRepository;

//    @Resource
    @Autowired
    private MechanicConverter mechanicConverter;

    @Override
    public List<MechanicDto> listAllMechanics() {
        List<Mechanic> mechanicList =
                mechanicRepository.findAll();
        return mechanicList.stream()
                .map(mechanicConverter::toDto)
                .collect(Collectors.toList());
    }
}
//
//    @Override
//    public MechanicDto addMechanic(MechanicDto mechanicDto) {
//        return null;
//    }
//
//    @Override
//    public MechanicDto updateMechanic(Integer mechanicId, MechanicDto mechanicDto) {
//        return null;
//    }
//}//