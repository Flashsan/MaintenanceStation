package com.it.academy.maintenancestation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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

    ////    We are not using cascade type ALL, as this may propagate the delete operation to the courses as well and deletes all the associated courses if a student object is deleted.
    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "work_list_mechanic",
            joinColumns = {@JoinColumn(name = "work_list_id")},
            inverseJoinColumns = {@JoinColumn(name = "mechanic_id")}
    )
    private Set<Mechanic> mechanic = new HashSet<>();

    public void addMechanic(Mechanic mechanicAdd) {
        this.mechanic.add(mechanicAdd);
    }

//    @OneToMany(mappedBy = "workList")
//    private Set<SparePart> sparePart;

//    @ManyToOne
//    @JoinColumn(name = "orders_id")
//    private Orders orders;


}
