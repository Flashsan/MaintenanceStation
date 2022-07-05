package com.it.academy.maintenancestation.dto;

import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WorkListDto {

    private Integer workListId;
    private String workListName;
    private String workListCoast;
//    private Set<String> mechanics = new HashSet<>();


}
