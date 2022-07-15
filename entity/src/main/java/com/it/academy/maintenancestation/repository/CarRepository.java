package com.it.academy.maintenancestation.repository;

import com.it.academy.maintenancestation.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository
        extends JpaRepository<Client, Integer> {
}
