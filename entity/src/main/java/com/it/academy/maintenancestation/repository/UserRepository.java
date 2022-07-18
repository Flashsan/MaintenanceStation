package com.it.academy.maintenancestation.repository;

import com.it.academy.maintenancestation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepository
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

@Repository
public interface UserRepository
        extends JpaRepository<User, Integer> {
    User findByUserName(String username);

}
