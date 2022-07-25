package com.it.academy.maintenancestation.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * ClientDetails entity.
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

@Entity
@Table(name = "client_details")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClientDetails implements Serializable {
    /**
     * id entity clientDetails.
     */
    @Id
    @GenericGenerator(
            name = "one-to-one(client-client_details)",
            strategy = "foreign",
            parameters = @Parameter(name = "property", value = "client")
    )
    @GeneratedValue(generator = "one-to-one(client-client_details)")
    @Column(name = "client_details_id")
    private Integer clientDetailsId;

    /**
     * serial number passport entity clientDetails.
     */
    @Column(name = "client_details_num_passport")
    private String clientDetailsNumberPassport;

    /**
     * Additional information.
     */
    @OneToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private Client client;
}
