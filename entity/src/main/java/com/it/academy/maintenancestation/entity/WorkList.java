package com.it.academy.maintenancestation.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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

    /**
     * id workList
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "work_list_id")
    private Integer workListId;

    /**
     * name workList
     */
    @Column(name = "work_list_name")
    private String workListName;

    /**
     * coast workList
     */
    @Column(name = "work_list_coast")
    private String workListCoast;

    /**
     * List mechanics which do it this workList
     */
    @ManyToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.MERGE)
    @JoinTable(
            name = "work_list_mechanic",
            joinColumns = {@JoinColumn(name = "work_list_id")},
            inverseJoinColumns = {@JoinColumn(name = "mechanic_id")})
    private List<Mechanic> mechanic;

    /**
     * List SparePart for repair
     */
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.MERGE)
    @JoinTable(
            name = "work_list_spare_part",
            joinColumns = {@JoinColumn(name = "work_list_id")},
            inverseJoinColumns = {@JoinColumn(name = "spare_part_id")})
    private List<SparePart> sparePart;

    /**
     * task related to the order
     */
    @ManyToOne
    @JoinColumn(name = "orders_id")
    private Orders orders;
}
