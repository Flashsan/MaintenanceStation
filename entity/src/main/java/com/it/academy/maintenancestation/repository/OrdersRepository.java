package com.it.academy.maintenancestation.repository;


import com.it.academy.maintenancestation.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository
        extends JpaRepository<Orders, Integer> {

}
