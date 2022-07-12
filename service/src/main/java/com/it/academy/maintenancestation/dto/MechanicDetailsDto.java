package com.it.academy.maintenancestation.dto;


import com.it.academy.maintenancestation.entity.Mechanic;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MechanicDetailsDto {

    private Integer mechanicId;
    private String mechanicExperience;
    private String mechanicSalary;

}
