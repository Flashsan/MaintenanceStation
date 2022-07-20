package com.it.academy.maintenancestation.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Order entity
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

@Entity
@Table(name = "orders")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Orders implements Serializable {
    /**
     * id entity order.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orders_id")
    private Integer ordersId;

    /**
     * order description entity order.
     */
    @Column(name = "orders_description")
    private String ordersDescription;

    /**
     * order inspection result entity order.
     */
    @Column(name = "orders_inspection_result")
    private String ordersInspectionResult;

    /**
     * administrator which accept order.
     */
    @ManyToOne
    @JoinColumn(name = "administrator_id")
    private Administrator administrator;

    /**
     * List orders for car.
     */
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @OneToMany(mappedBy = "orders")
    private Set<WorkList> workList;


}
