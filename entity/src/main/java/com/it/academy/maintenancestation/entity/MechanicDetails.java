package com.it.academy.maintenancestation.entity;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * MechanicDetails entity.
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

@Entity
@Table(name = "mechanic_details")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MechanicDetails implements Serializable {
    /**
     * id entity mechanicDetails.
     */
    @Id
    @GenericGenerator(
            name = "one-to-one(mechanic-mechanic_details)",
            strategy = "foreign",
            parameters = @Parameter(name = "property", value = "mechanic")
    )
    @GeneratedValue(generator = "one-to-one(mechanic-mechanic_details)")
    @Column(name = "mechanic_details_id")
    private Integer mechanicDetailsId;

    /**
     * experience entity mechanicDetails.
     */
    @Column(name = "mechanic_details_experience")
    private String mechanicDetailsExperience;

    /**
     * salary entity mechanicDetails.
     */
    @Column(name = "mechanic_details_salary")
    private String mechanicDetailsSalary;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Mechanic mechanic;
}
