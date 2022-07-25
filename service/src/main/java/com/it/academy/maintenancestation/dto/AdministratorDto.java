package com.it.academy.maintenancestation.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * AdministratorDto
 *
 * @version 12.07.2022
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdministratorDto implements Serializable {

    private Integer administratorId;

    @NotEmpty(message = "Name shouldn't be empty!")
    @Size(min = 2, max = 30, message = "{Size.AdministratorDto.administratorName}")
    private String administratorName;

    @NotEmpty(message = "LastName shouldn't be empty!")
    @Size(min = 2, max = 50, message = "{Size.AdministratorDto.administratorLastName}")
    private String administratorLastName;

    private AdministratorDetailsDto administratorDetails;

    private List<OrdersDto> orders;


}
