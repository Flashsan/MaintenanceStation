package com.it.academy.maintenancestation.dto;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDetailsDto implements Serializable   {

    private Integer clientDetailsId;

    private String clientDetailsNumberPassport;
}
