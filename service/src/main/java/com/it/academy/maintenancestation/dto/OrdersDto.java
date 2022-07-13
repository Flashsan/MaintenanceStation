package com.it.academy.maintenancestation.dto;

import com.it.academy.maintenancestation.entity.Administrator;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrdersDto implements Serializable {

    private Integer ordersId;
    private String ordersDescription;
    private String ordersInspectionResult;
//    private AdministratorDto administratorDto;

}
