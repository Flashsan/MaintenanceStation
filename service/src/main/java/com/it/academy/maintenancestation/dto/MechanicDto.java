package com.it.academy.maintenancestation.dto;


import lombok.*;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MechanicDto {

    private Integer mechanicId;
    private String mechanicName;
    private String mechanicLastName;
    private Set<WorkListDto> workList = new HashSet<>();

    @Override
    public String toString() {
        return "MechanicDto{" +
                "mechanicId=" + mechanicId +
                ", mechanicName='" + mechanicName + '\'' +
                ", mechanicLastName='" + mechanicLastName + '\'' +
                '}';
    }
}
