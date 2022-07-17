package com.it.academy.maintenancestation.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * AdministratorDetails entity.
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

@Entity
@Table(name = "administrator_details")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AdministratorDetails implements Serializable {
    /**
     * id entity administratorDetails.
     */
    @Id
    @GenericGenerator(
            name = "one-to-one(administrator-administrator_details)",
            strategy = "foreign",
            parameters = @Parameter(name = "property", value = "administrator"))
    @GeneratedValue(
            generator = "one-to-one(administrator-administrator_details)")
    @Column(name = "administrator_details_id")
    private Integer administratorDetailsId;

    /**
     * experience entity administratorDetails.
     */
    @Column(name = "administrator_details_experience")
    private String administratorDetailsExperience;

    @OneToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private Administrator administrator;


}
