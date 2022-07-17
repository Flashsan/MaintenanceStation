package com.it.academy.maintenancestation.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Client entity.
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

@Entity
@Table(name = "client")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Client implements Serializable {
    /**
     * id entity client.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Integer clientId;

    /**
     * name entity client.
     */
    @Column(name = "client_name")
    private String clientName;

    /**
     * lastname entity client.
     */
    @Column(name = "client_last_name")
    private String clientLastName;

    /**
     * additional details for entity client.
     */
    @OneToOne(
            mappedBy = "client",
            cascade = CascadeType.ALL)
    private ClientDetails clientDetails;

    /**
     * list cars entity client.
     */
    @OneToMany(
            mappedBy = "client",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private Set<Car> car;

}
