package com.usach.AGUILA_COMEX_be.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "for_delivery")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ForDeliveryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String company_name;
    private String company_adress;
    private String company_phone;
    private String company_email;

    /*@OneToOne(mappedBy = "for_delivery",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private BLEntity bl;*/
}
