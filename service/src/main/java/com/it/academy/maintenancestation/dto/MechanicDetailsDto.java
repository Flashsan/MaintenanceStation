package com.it.academy.maintenancestation.dto;


import lombok.*;

/**
 * MechanicDetailsDto
 *
 * @version 12.07.2022
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MechanicDetailsDto {

    private Integer mechanicDetailsId;

    private String mechanicDetailsExperience;

    private String mechanicDetailsSalary;

    private MechanicDto mechanic;
}
