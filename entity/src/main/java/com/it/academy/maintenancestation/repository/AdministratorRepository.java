package com.it.academy.maintenancestation.repository;

import com.it.academy.maintenancestation.entity.Administrator;
import com.it.academy.maintenancestation.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdministratorRepository
        extends JpaRepository<Administrator, Integer> {

    @Query("select e.orders from Administrator e where e.administratorId = ?1")
    List<Orders> getAdministratorsOrders(Integer administratorId);
}
