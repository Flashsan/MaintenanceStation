package com.it.academy.maintenancestation.dto;

import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdministratorDto implements Serializable {

    private Integer administratorId;
    private String administratorName;
    private String administratorLastName;

}
