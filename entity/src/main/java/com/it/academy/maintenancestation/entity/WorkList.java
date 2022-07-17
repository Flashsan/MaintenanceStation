package com.it.academy.maintenancestation.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * WorkList entity
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

@Entity
@Table(name = "work_list")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WorkList implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "work_list_id")
    private Integer workListId;

    @Column(name = "work_list_name")
    private String workListName;

    @Column(name = "work_list_coast")
    private String workListCoast;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "work_list_mechanic",
            joinColumns = {@JoinColumn(name = "work_list_id")},
            inverseJoinColumns = {@JoinColumn(name = "mechanic_id")})
    private Set<Mechanic> mechanic = new HashSet<>();

    @OneToMany(mappedBy = "workList")
    private Set<SparePart> sparePart;

    @ManyToOne
    @JoinColumn(name = "orders_id")
    private Orders orders;


}
