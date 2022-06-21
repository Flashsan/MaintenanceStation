package com.it.academy.maintenancestation.service.impl;

import com.it.academy.maintenancestation.entity.Administrator;
import com.it.academy.maintenancestation.repository.AdministratorRepository;
import com.it.academy.maintenancestation.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AdministratorServiceImpl
        implements AdministratorService {

    @Autowired
    private AdministratorRepository administratorRepository;

    @Override
    public List<Administrator> listAllAdministrators() {
        return administratorRepository.findAll();
    }

    @Override
    public Optional<Administrator> findAdministratorById(Integer administratorId) {
        return administratorRepository.findById(administratorId);
    }

    @Override
    public void saveAdministrator(Administrator administrator) {
        administratorRepository.save(administrator);
    }

    @Override
    public void deleteAdministratorById(Integer administratorId) {
        administratorRepository.deleteById(administratorId);
    }
}
