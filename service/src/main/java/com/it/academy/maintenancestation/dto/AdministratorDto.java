package com.it.academy.maintenancestation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdministratorDto implements Serializable {

    private Integer administratorId;
    private String administratorName;
    private String administratorLastName;
    private AdministratorDetailsDto administratorDetails;
    private List<OrdersDto> orders;



}
