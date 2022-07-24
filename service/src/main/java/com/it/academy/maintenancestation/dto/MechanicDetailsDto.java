package com.it.academy.maintenancestation.dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MechanicDetailsDto {

    private Integer mechanicDetailsId;

    private String mechanicDetailsExperience;

    private String mechanicDetailsSalary;

    private MechanicDto mechanic;
}
