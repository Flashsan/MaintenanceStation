package com.it.academy.maintenancestation.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "spare_part")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SparePart implements Serializable {

    /**
     * id entity sparePart.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "spare_part_id")
    private Integer sparePartId;

    /**
     * name entity sparePart.
     */
    @Column(name = "spare_part_name_part")
    private String sparePartNamePart;

    /**
     * brand entity sparePart.
     */
    @Column(name = "spare_part_brand")
    private String sparePartBrand;

    /**
     * coast entity sparePart.
     */
    @Column(name = "spare_part_coast")
    private String sparePartCoast;

    /**
     * List workList where used this sparePart.
     */
    @ManyToMany(mappedBy = "sparePart")
    private List<WorkList> workList;

}
