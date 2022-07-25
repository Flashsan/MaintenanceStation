package com.it.academy.maintenancestation.dto;


import lombok.*;

import java.util.List;

/**
 * MechanicDto
 *
 * @version 12.07.2022
 */

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
