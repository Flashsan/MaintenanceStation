package com.it.academy.maintenancestation.dto;


import lombok.*;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MechanicDto {

    private Integer mechanicId;

    private String mechanicName;

    private String mechanicLastName;

    private MechanicDetailsDto mechanicDetails;

    private List<WorkListDto> workList;



}
