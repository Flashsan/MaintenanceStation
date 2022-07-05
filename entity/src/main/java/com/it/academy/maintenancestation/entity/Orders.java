package com.it.academy.maintenancestation.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "orders")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Orders implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orders_id")
    private Integer ordersId;

    @Column(name = "orders_description")
    private String ordersDescription;

    @Column(name = "orders_inspection_result")
    private String ordersInspectionResult;

//    @ManyToOne
//    @JoinColumn(name = "administrator_id")
//    private Administrator administrator;
//
////    @OneToMany(mappedBy = "orders")
////    private Set<WorkList> workList;
////
////    @OneToMany(mappedBy = "orders")
////    private Set<Car> car;
//

}
