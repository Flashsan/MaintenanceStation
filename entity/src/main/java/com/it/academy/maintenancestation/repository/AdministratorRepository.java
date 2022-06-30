package com.it.academy.maintenancestation.repository;


import com.it.academy.maintenancestation.entity.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//@Import(Administrator.class)
public interface AdministratorRepository
        extends JpaRepository<Administrator, Integer> {

}
