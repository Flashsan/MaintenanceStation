package com.it.academy.maintenancestation.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
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
@Data
public class Administrator implements Serializable {
    /**
     * id entity administrator.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "administrator_id"
    )
    private Integer administratorId;

    /**
     * name entity administrator.
     */
    @Column(
            name = "administrator_name"
    )
    @NotEmpty(message = "Name shouldn't be empty!")
    @Size(min = 2, max = 30, message = "{Size.Administrator.administratorName}")

//    @Pattern(regexp = "[a-zA-Z]*", message = "Только латинские буквы")
    private String administratorName;

    /**
     * lastname entity administrator.
     */
    @Column(
            name = "administrator_last_name"
    )
    @NotEmpty(message = "LastName shouldn't be empty!")
    @Size(min = 2, max = 50, message = "LastName should be between 2 and 50 characters!")
//    @Pattern(regexp = "[a-zA-Z]*", message = "Только латинские буквы")
    private String administratorLastName;

    /**
     * additional details for entity administrator.
     */
    @OneToOne(
            mappedBy = "administrator",
            cascade = CascadeType.ALL,
            orphanRemoval=true
    )
    private AdministratorDetails administratorDetails;

    /**
     * Administrator list of orders.
     */
    @OneToMany(
            mappedBy = "administrator",
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            fetch = FetchType.LAZY)
    private List<Orders> orders;


}
