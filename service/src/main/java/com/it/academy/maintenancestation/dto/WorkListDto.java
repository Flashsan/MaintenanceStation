package com.it.academy.maintenancestation.dto;

import lombok.*;

import java.io.Serializable;
import java.util.*;

/**
 * WorkListDto
 *
 * @version 12.07.2022
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkListDto implements Serializable {

    private Integer workListId;

    private String workListName;

    private String workListCoast;

    private List<MechanicDto> mechanic;

    private List<SparePartDto> sparePart;

    private OrdersDto orders;


}
