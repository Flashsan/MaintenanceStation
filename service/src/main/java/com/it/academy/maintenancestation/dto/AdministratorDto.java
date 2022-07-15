package com.it.academy.maintenancestation.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdministratorDto implements Serializable {

    private Integer administratorId;

    @NotEmpty(message = "Name shouldn't be empty!")
    @Size(min = 2, max = 30, message = "{Size.Administrator.administratorName}")
//    @Pattern(regexp = "[a-zA-Z]*", message = "Только латинские буквы")
    private String administratorName;

    @NotEmpty(message = "LastName shouldn't be empty!")
    @Size(min = 2, max = 50, message = "LastName should be between 2 and 50 characters!")
//    @Pattern(regexp = "[a-zA-Z]*", message = "Только латинские буквы")
    private String administratorLastName;

    private AdministratorDetailsDto administratorDetails;
    private List<OrdersDto> orders;


}
