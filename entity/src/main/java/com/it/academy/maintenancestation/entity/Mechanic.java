package com.it.academy.maintenancestation.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Administrator entity
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

@Entity
@Table(name = "mechanic")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Mechanic implements Serializable {
    /**
     * id entity mechanic.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mechanic_id")
    private Integer mechanicId;

    /**
     * name entity mechanic.
     */
    @Column(name = "mechanic_name")
    private String mechanicName;

    /**
     * lastname entity mechanic.
     */
    @Column(name = "mechanic_last_name")
    private String mechanicLastName;

    /**
     * additional details for entity mechanic.
     */
    @OneToOne(
            mappedBy = "mechanic",
            cascade = CascadeType.ALL
    )
    private MechanicDetails mechanicDetails;

    /**
     * List task for entity mechanic.
     */
    @ManyToMany(mappedBy = "mechanic")
    private List<WorkList> workList;
}
