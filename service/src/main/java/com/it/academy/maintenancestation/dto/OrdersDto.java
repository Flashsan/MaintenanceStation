package com.it.academy.maintenancestation.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * OrderDto
 *
 * @version 12.07.2022
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdersDto implements Serializable {

    private Integer ordersId;

    private String ordersDescription;

    private String ordersInspectionResult;

    private List<WorkListDto> workList;

    @JsonIgnore
    private AdministratorDto administrator;

    private CarDto car;
}
