package com.it.academy.maintenancestation.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdersDto implements Serializable {

    private Integer ordersId;

    private String ordersDescription;

    private String ordersInspectionResult;
//    @JsonManagedReference
    @JsonIgnore
    private AdministratorDto administrator;

}
