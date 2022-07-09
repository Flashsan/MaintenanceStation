package com.it.academy.maintenancestation.dto;

import lombok.*;

import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrdersDto {

    private Integer iDMechanic;
    private String nameMechanic;
    private String lastNameMechanic;
    private Set<WorkListDto> workListsMechanicDto;

}
