package com.it.academy.maintenancestation.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * User entity
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User {

    /**
     * id user
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    /**
     * userName
     */
    @NotBlank(message = "Не должно быть пустым")
    @Size(min = 3, max = 16, message = "Длинна userName должна быть от 3 до 15 символов")
    @Pattern(regexp = "[a-zA-Z]*", message = "Только латинские буквы")
    @Column(name = "user_name")
    private String userName;

    /**
     * password user
     */
    @Column(name = "user_password")
    private String userPassword;

    /**
     * status for user
     */
    @Column(name = "user_activate")
    private boolean userActivate;

    /**
     * Role which user have
     */
//
    @Column(name = "user_roles")
    @ElementCollection(targetClass= Role.class, fetch =FetchType.LAZY)
    @CollectionTable(name="user_role", joinColumns = @JoinColumn(name= "users_user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;
}
