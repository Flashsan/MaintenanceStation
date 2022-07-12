package com.it.academy.maintenancestation.service.impl;

import com.it.academy.maintenancestation.converter.impl.SparePartMapper;
import com.it.academy.maintenancestation.dto.SparePartDto;
import com.it.academy.maintenancestation.entity.SparePart;
import com.it.academy.maintenancestation.repository.SparePartRepository;
import com.it.academy.maintenancestation.service.SparePartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SparePartServiceImpl
        implements SparePartService {

    @Autowired
    private SparePartRepository sparePartRepository;

    @Autowired
    private SparePartMapper sparePartConverter;

    @Override
    public List<SparePartDto> listAllSparePart() {
        List<SparePart> sparePartsList =
                sparePartRepository.findAll();
        return sparePartsList.stream()
                .map(sparePartConverter::toDto)
                .collect(Collectors.toList());
    }
}
//
//    @Override
//    public Administrator findAdministratorById(Integer administratorId) {
//        return administratorRepository.findById(administratorId).get();
//    }
//
//    @Override
//    public void newAdministrator(AdministratorDto administratorDto) {
//        administratorRepository.save(administratorConverter.toEntity(administratorDto));
//    }
//
//    @Override
//    public void deleteAdministratorById(Integer administratorId) {
//        administratorRepository.deleteById(administratorId);
//    }

