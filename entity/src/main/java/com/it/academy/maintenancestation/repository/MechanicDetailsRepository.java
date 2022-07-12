package com.it.academy.maintenancestation.repository;

import com.it.academy.maintenancestation.entity.Mechanic;
import com.it.academy.maintenancestation.entity.MechanicDetails;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Import(Mechanic.class)
public interface MechanicDetailsRepository
        extends JpaRepository<MechanicDetails, Integer> {

}
