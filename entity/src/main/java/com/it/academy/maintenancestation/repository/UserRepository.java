package com.it.academy.maintenancestation.repository;

import com.it.academy.maintenancestation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository
        extends JpaRepository<User, Integer> {
    User findByUserName(String username);

}
