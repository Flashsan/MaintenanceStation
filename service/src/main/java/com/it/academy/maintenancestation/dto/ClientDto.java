package com.it.academy.maintenancestation.dto;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * ClientDetailsDto
 *
 * @version 12.07.2022
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto implements Serializable {

    private Integer clientId;

    private String clientName;

    private String clientLastName;

    private ClientDetailsDto clientDetails;
}
