package com.it.academy.maintenancestation.dto;

import com.it.academy.maintenancestation.entity.Mechanic;
import lombok.*;

import java.util.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WorkListDto {

    private Integer workListId;
    private String workListName;
    private String workListCoast;
    private Set<MechanicDto> mechanic = new HashSet<>();

    @Override
    public String toString() {
        return "WorkListDto{" +
                "workListId=" + workListId +
                ", workListName='" + workListName + '\'' +
                ", workListCoast='" + workListCoast + '\'' +
                '}';
    }
}
