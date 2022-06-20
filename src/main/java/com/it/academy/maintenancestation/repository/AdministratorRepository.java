package com.it.academy.maintenancestation.repository;

import com.it.academy.maintenancestation.entity.Administrator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorRepository
        extends CrudRepository<Administrator, Integer> {
}
