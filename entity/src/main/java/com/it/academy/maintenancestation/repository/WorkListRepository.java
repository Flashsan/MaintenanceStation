package com.it.academy.maintenancestation.repository;


import com.it.academy.maintenancestation.entity.WorkList;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Import(WorkList.class)
public interface WorkListRepository
        extends JpaRepository<WorkList, Integer> {

}
