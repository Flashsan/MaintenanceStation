package com.it.academy.maintenancestation.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Car entity
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

@Entity
@Table(name = "car")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Car implements Serializable {
    /**
     * id entity car.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Integer carId;

    /**
     * model entity car.
     */
    @Column(name = "car_model")
    private String carModel;

    /**
     * color entity car.
     */
    @Column(name = "car_color")
    private String carColor;

    /**
     * number entity car.
     */
    @Column(name = "car_number")
    private String carNumber;

    /**
     * additional details for entity car.
     */
    @OneToOne(
            mappedBy = "car",
            cascade = CascadeType.ALL)
    private CarDetails carDetails;

    /**
     * List orders for entity car.
     */
    @OneToMany(
            mappedBy = "car",
            cascade = {
                    CascadeType.MERGE,
                    CascadeType.PERSIST},
            fetch = FetchType.LAZY)
    private List<Orders> orders;

    /**
     * List car client.
     */
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
