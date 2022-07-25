package com.it.academy.maintenancestation.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "administrator")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Administrator implements Serializable {
    /**
     * id entity administrator.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "administrator_id")
    private Integer administratorId;

    /**
     * name entity administrator.
     */
    @Column(name = "administrator_name")
    private String administratorName;

    /**
     * lastname entity administrator.
     */
    @Column(name = "administrator_last_name")
    private String administratorLastName;

    /**
     * additional details for entity administrator.
     */
    @JsonManagedReference
    @OneToOne(
            mappedBy = "administrator",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private AdministratorDetails administratorDetails;

    /**
     * List accepted orders.
     */
    @JsonManagedReference
    @OneToMany(
            mappedBy = "administrator",
            cascade = {
                    CascadeType.MERGE,
                    CascadeType.PERSIST},
            fetch = FetchType.LAZY)
    private List<Orders> orders;

}
