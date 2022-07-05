package com.it.academy.maintenancestation.repository;


import com.it.academy.maintenancestation.entity.Orders;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Import(Orders.class)
public interface OrderRepository
        extends JpaRepository<Orders, Integer> {

}
