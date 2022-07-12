package com.it.academy.maintenancestation.repository;


import com.it.academy.maintenancestation.entity.SparePart;
import com.it.academy.maintenancestation.entity.WorkList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SparePartRepository
        extends JpaRepository<SparePart, Integer> {

}
