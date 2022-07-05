package com.it.academy.maintenancestation.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "client")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Client implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Integer clientId;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "client_last_name")
    private String clientLastName;
//
//        @OneToOne(
//            mappedBy = "client",
//            cascade = CascadeType.ALL
//    )
//    private ClientDetails clientDetails;
//
//    @OneToMany(
//            mappedBy = "client",
//            fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//    private List<Car> car;

}
