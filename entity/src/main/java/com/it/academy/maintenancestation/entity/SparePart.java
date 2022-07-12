package com.it.academy.maintenancestation.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "spare_part")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SparePart implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "spare_part_id")
    private Integer sparePartId;

    @Column(name = "spare_part_name_part")
    private String sparePartNamePart;

    @Column(name = "spare_part_brand")
    private String sparePartBrand;

    @Column(name = "spare_part_coast")
    private String sparePartCoast;

    @ManyToOne
    @JoinColumn(name = "work_list_id")
    private WorkList workList;
}
