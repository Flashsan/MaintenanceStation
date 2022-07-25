package com.it.academy.maintenancestation.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * CarDto
 *
 * @version 12.07.2022
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDto implements Serializable  {

    private Integer carId;

    private String carModel;

    private String carColor;

    private String carNumber;

    private CarDetailsDto carDetails;

    private List<OrdersDto> orders;
}
