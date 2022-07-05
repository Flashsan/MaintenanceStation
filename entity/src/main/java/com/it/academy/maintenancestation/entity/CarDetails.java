package com.it.academy.maintenancestation.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "car_details")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CarDetails implements Serializable {
    @Id
    @GenericGenerator(
            name = "one-to-one(car-car_details",
            strategy = "foreign",
            parameters = @Parameter(name = "property", value = "car")
    )
    @GeneratedValue(generator = "one-to-one(car-car_details")
    @Column(name = "car_details__id")
    private Integer carDetailsId;

    @Column(name = "car_details_type_engine")
    private String carDetailsTypeEngine;

    @Column(name = "car_details_value_engine")
    private String carDetailsValueEngine;

    @Column(name = "car_details_type_transmission")
    private String carDetailsTypeTransmission;

    @Column(name = "car_details_type_body")
    private String carDetailsTypeBody;

    @Column(name = "car_details_year_of_issue")
    private String carDetailsYearOfIssue;

//    @OneToOne(fetch = FetchType.LAZY)
//    @PrimaryKeyJoinColumn
//    private Car car;


}
