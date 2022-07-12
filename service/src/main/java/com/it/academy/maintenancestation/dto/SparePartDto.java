package com.it.academy.maintenancestation.dto;

import com.it.academy.maintenancestation.entity.WorkList;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SparePartDto implements Serializable {
    private Integer sparePartId;
    private String sparePartNamePart;
    private String sparePartBrand;
    private String sparePartCoast;
    private Integer workListId;


}
