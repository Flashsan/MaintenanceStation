package com.it.academy.maintenancestation.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "car")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Car implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Integer carId;

    @Column(name = "car_model")
    private String carModel;

    @Column(name = "car_color")
    private String carColor;

    @Column(name = "car_number")
    private String carNumber;

//    @OneToOne(
//            mappedBy = "car",
//            cascade = CascadeType.ALL
//    )
//    private CarDetails carDetails;
//
////    @ManyToOne
//    @JoinColumn(name = "orders_id")
//    private Orders orders;
}
