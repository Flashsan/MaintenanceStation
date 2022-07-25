package com.it.academy.maintenancestation.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * CarDetails entity.
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

@Entity
@Table(name = "car_details")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CarDetails implements Serializable {
    /**
     * id entity carDetails.
     */
    @Id
    @GenericGenerator(
            name = "one-to-one(car-car_details)",
            strategy = "foreign",
            parameters = @Parameter(name = "property", value = "car"))
    @GeneratedValue(
            generator = "one-to-one(car-car_details)")
    @Column(name = "car_details_id")
    private Integer carDetailsId;

    /**
     * type engine entity carDetails.
     */
    @Column(name = "car_details_type_engine")
    private String carDetailsTypeEngine;

    /**
     * value_engine engine entity carDetails.
     */
    @Column(name = "car_details_value_engine")
    private String carDetailsValueEngine;

    /**
     * type transmission entity carDetails.
     */
    @Column(name = "car_details_type_transmission")
    private String carDetailsTypeTransmission;

    /**
     * type body entity carDetails.
     */
    @Column(name = "car_details_type_body")
    private String carDetailsTypeBody;

    /**
     * year of issue entity carDetails.
     */
    @Column(name = "car_details_year_of_issue")
    private String carDetailsYearOfIssue;

    /**
     * Client which have this detail information.
     */
    @OneToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private Car car;

}
