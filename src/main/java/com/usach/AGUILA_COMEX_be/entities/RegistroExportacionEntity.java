package com.usach.AGUILA_COMEX_be.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "registro_exportacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistroExportacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String type_shipment;
    private Integer operation_id;
    private String company_name;
    private String current_status;
    private Boolean sidemar;
    private Boolean freight_payable;
    private Boolean freight_paid;
    private Boolean liberated;
    private String description;
    private LocalDate etd;
    private LocalDate eta;
    private String hbl;
    private String mbl;
    private String ocean_vessel;
    private String t_t;
    private String container;
    private String clause;
    private String port_loading;
    private String port_discharge;
    private LocalDate return__vacancies;
    private Float gross_weight;
    private Float measurement;
    private String carrier;
    private Boolean archived;

    /*@OneToOne(mappedBy = "registroExportacion",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private BLEntity bl;

    @OneToMany(mappedBy = "registroExportacion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BultosEntity> bultos;*/
}
