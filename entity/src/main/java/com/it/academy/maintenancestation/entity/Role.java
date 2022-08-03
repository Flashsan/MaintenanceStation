package com.it.academy.maintenancestation.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Role enum
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */
public enum Role implements GrantedAuthority {
    ADMIN("admin"),
    ADMINISTRATOR("administrator"),
    CLIENT("client"),
    MECHANIC("mechanic");

    Role(String role) {
        this.role = role;
    }

    private String role;

    @Override
    public String getAuthority() {
        return role;
    }
}
