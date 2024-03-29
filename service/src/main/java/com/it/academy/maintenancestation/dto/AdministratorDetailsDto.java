package com.it.academy.maintenancestation.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.io.Serializable;

/**
 * AdministratorDetailsDto
 *
 * @version 12.07.2022
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdministratorDetailsDto implements Serializable {

    private Integer administratorDetailsId;

    private String administratorDetailsExperience;

    @JsonIgnore
    private AdministratorDto administrator;

}
