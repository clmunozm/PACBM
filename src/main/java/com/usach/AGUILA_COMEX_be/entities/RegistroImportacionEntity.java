package com.usach.AGUILA_COMEX_be.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "registro_importacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistroImportacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String type_shipment;
    private Integer operation_id;
    private String company_name;
    private String current_status;
    private String description;
    private LocalDate etd;
    private LocalDate eta;
    private Boolean shipping_letter;
    private Boolean sidemar;
    private Boolean canje;
    private String t_t;
    private String ocean_vessel;
    private String hbl;
    private String mbl;
    private String container;
    private Integer free_days;
    private String carrier;
    private String clause;
    private String port_loading;
    private String port_discharge;
    private LocalDate return_vacancies;
    private Boolean archived;


    /*@OneToOne(cascade = CascadeType.ALL,mappedBy = "registroImportacion", fetch = FetchType.LAZY)
    private BLEntity bl;

    @OneToMany(mappedBy = "registroImportacion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BultosEntity> bultos;*/
}
