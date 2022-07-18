package com.it.academy.maintenancestation.dto;

import lombok.*;

import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClientDetailsDto implements Serializable   {

    private Integer clientDetailsId;

    private String clientDetailsNumberPassport;
}
