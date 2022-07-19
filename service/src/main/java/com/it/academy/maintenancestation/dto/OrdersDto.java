package com.it.academy.maintenancestation.dto;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrdersDto implements Serializable {

    private Integer ordersId;

    private String ordersDescription;

    private String ordersInspectionResult;

    private AdministratorDto administrator;

}
