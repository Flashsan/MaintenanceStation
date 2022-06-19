package com.it.academy.maintenancestation.entity;

import lombok.Data;

@Data
public class Administrator {

    private Integer administratorId;
    private String administratorName;
    private String administratorLastName;


    //    @OneToMany(mappedBy = "administrator", fetch = FetchType.LAZY)
//    private List<Orders> orders;
}
