package com.it.academy.maintenancestation.dto;

import lombok.*;

import javax.persistence.Column;
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
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters!")
    private String administratorName;

    @NotEmpty(message = "LastName shouldn't be empty!")
    @Size(min = 2, max = 50, message = "LastName should be between 2 and 50 characters!")
    private String administratorLastName;

}
