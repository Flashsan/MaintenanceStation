package com.it.academy.maintenancestation.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Administrator implements Serializable {

    /**
     * id entity administrator.
     */
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "administrator_id"
    )
    private Integer administratorId;

    /**
     * name entity administrator.
     */
    @Column(
            name = "administrator_name"
    )
    private String administratorName;

    /**
     * lastname entity administrator.
     */
    @Column(
            name = "administrator_last_name"
    )
    private String administratorLastName;

}
