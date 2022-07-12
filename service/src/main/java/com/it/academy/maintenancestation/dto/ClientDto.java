package com.it.academy.maintenancestation.dto;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClientDto implements Serializable  {

    private Integer clientId;
    private String clientName;
    private String clientLastName;

}
