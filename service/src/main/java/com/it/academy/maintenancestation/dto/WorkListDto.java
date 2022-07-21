package com.it.academy.maintenancestation.dto;

import com.it.academy.maintenancestation.entity.Mechanic;
import lombok.*;

import java.io.Serializable;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class WorkListDto implements Serializable {

    private Integer workListId;

    private String workListName;

    private String workListCoast;

    private List<MechanicDto> mechanic;

    private List<SparePartDto> sparePart;


}
