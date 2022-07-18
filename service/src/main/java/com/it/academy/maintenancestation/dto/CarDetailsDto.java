package com.it.academy.maintenancestation.dto;

import lombok.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CarDetailsDto implements Serializable {

    private Integer carDetailsId;

    private String carDetailsTypeEngine;

    private String carDetailsValueEngine;

    private String carDetailsTypeTransmission;

    private String carDetailsTypeBody;

    private String carDetailsYearOfIssue;

    private CarDetailsDto carDetails;


}
