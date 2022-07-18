package com.it.academy.maintenancestation.dto;


import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MechanicDto {

    private Integer mechanicId;

    private String mechanicName;

    private String mechanicLastName;

    private MechanicDetailsDto mechanicDetails;

    private Set<WorkListDto> workList;


}
