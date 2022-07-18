package com.it.academy.maintenancestation.repository;


import com.it.academy.maintenancestation.entity.WorkList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * WorkListRepository
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

@Repository
public interface WorkListRepository
        extends JpaRepository<WorkList, Integer> {

}
