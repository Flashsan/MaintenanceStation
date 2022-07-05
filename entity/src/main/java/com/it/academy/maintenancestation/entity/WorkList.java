package com.it.academy.maintenancestation.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


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
//    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @JoinTable(
//            name = "work_list_mechanic",
//            joinColumns = {@JoinColumn(name = "work_list_id")},
//            inverseJoinColumns = {@JoinColumn(name = "mechanic_id")}
//    )
//    private Set<Mechanic> mechanic = new HashSet<>();
//
////    The addCourse() and the removeCourse() methods are used to create/remove association with the course entity for a particular student entity.
//    public void addMechanic(Mechanic mechanic){
//        this.mechanic.add(mechanic);
//        mechanic.getWorkList().add(this);
//    }
//
//    public void removeMechanic(Mechanic mechanic){
//        this.getMechanic().remove(mechanic);
//        mechanic.getWorkList().remove(this);
//    }
/*
The removeCourses() method is used to remove the mapping of the existing courses with the student entity before deleting it.
// */
//    public void removeMechanic(){
//        for(Mechanic mechanic : new HashSet<>(mechanic)){
//            removeMechanic(mechanic);
//        }
//    }



    //    @OneToMany(mappedBy = "workList")
//    private Set<SparePart> sparePart;

//    @ManyToOne
//    @JoinColumn(name = "orders_id")
//    private Orders orders;


}
