package com.it.academy.maintenancestation.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SparePartDto implements Serializable {

    private Integer sparePartId;

    private String sparePartNamePart;

    private String sparePartBrand;

    private String sparePartCoast;

    private List<WorkListDto> workList;
}
