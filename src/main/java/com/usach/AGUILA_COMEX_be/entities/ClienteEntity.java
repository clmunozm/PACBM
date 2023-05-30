package com.usach.AGUILA_COMEX_be.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String company_name;
    private String company_rut;
    private String company_email;
    private String company_phone;
    private String legal_representative;
    private String representative_rut;
    private String legal_office_address;
    private String finance_manager_name;
    private String finance_manager_email;
    private String finance_manager_phone;
    private String comex_manager_name;
    private String comex_manager_email;
    private String comex_manager_phone;

}
