package com.it.academy.maintenancestation.repository;


import com.it.academy.maintenancestation.entity.Mechanic;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Import(Mechanic.class)
public interface MechanicRepository
        extends JpaRepository<Mechanic, Integer> {
 //   public Mechanic findByName(String mechanicName);

}
