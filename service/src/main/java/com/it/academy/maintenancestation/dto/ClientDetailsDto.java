package com.it.academy.maintenancestation.dto;

import lombok.*;

import java.io.Serializable;

/**
 * ClientDetailsDto
 *
 * @version 12.07.2022
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDetailsDto implements Serializable   {

    private Integer clientDetailsId;

    private String clientDetailsNumberPassport;
}
