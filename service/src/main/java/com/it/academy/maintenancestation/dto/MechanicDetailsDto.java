package com.it.academy.maintenancestation.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MechanicDetailsDto {

    private Integer mechanicDetailsId;

    private String mechanicDetailsExperience;

    private String mechanicDetailsSalary;

    private MechanicDto mechanic;
}
