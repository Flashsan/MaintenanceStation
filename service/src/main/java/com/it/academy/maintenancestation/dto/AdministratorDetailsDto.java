package com.it.academy.maintenancestation.dto;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AdministratorDetailsDto implements Serializable {
    private Integer administratorDetailsId;
    private String administratorDetailsExperience;
    private AdministratorDto administrator;

}
