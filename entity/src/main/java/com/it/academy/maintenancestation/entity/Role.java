package com.it.academy.maintenancestation.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Role entity
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

@Entity
@Table(name = "roles")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", nullable = false)
    private Integer roleId;

    @Column(name = "role_name")
    private String name;

    @ManyToMany(mappedBy = "roles",
            fetch = FetchType.EAGER)
    private Set<User> userSet;
}
