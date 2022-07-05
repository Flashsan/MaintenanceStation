package com.it.academy.maintenancestation.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "mechanic")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Mechanic implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mechanic_id")
    private Integer mechanicId;

    @Column(name = "mechanic_name")
    private String mechanicName;

    @Column(name = "mechanic_last_name")
    private String mechanicLastName;


//    @ManyToMany(mappedBy = "mechanic")
//    private Set<WorkList> workList = new HashSet<>();

//
//    @OneToOne(
//            mappedBy = "mechanic",
//            cascade = CascadeType.ALL
//    )
//    private MechanicDetails mechanicDetails;
//

}
