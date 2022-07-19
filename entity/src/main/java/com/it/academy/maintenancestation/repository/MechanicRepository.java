package com.it.academy.maintenancestation.repository;


import com.it.academy.maintenancestation.entity.Mechanic;
import com.it.academy.maintenancestation.entity.Orders;
import com.it.academy.maintenancestation.entity.WorkList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * MechanicRepository
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

@Repository
public interface MechanicRepository
        extends JpaRepository<Mechanic, Integer> {
    /**
     * list task orders by administrator
     *
     * @param mechanicId
     * @return
     */
    @Query("select e.workList from Mechanic e where e.mechanicId = ?1")
    List<WorkList> getMechanicTask(Integer mechanicId);
}
