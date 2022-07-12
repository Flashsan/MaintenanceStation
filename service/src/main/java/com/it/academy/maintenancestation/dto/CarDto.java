package com.it.academy.maintenancestation.dto;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CarDto implements Serializable  {
    private Integer carId;
    private String carModel;
    private String carColor;
    private String carNumber;

}
