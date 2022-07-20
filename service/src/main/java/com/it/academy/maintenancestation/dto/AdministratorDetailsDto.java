package com.it.academy.maintenancestation.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AdministratorDetailsDto implements Serializable {

    private Integer administratorDetailsId;

    private String administratorDetailsExperience;
//    @JsonManagedReference
@JsonIgnore
    private AdministratorDto administrator;

}
