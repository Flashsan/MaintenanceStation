package com.it.academy.maintenancestation.repository;


import com.it.academy.maintenancestation.entity.Orders;
import com.it.academy.maintenancestation.entity.WorkList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * WorkListRepository
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

@Repository
public interface WorkListRepository
        extends JpaRepository<WorkList, Integer> {
    /**
     * list sparePart for workList
     *
     * @param workListId
     * @return
     */
    @Query("select e.sparePart from WorkList e where e.workListId = ?1")
    List<Orders> getListSparePartForOrders(Integer workListId);
}
