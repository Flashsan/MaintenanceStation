package com.it.academy.maintenancestation.dto;

import com.it.academy.maintenancestation.entity.CarDetails;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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
