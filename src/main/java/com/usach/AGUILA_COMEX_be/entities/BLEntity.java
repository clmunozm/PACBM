package com.usach.AGUILA_COMEX_be.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "bl")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BLEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private Integer operation_id;
    private String shipper_name;
    private String shipper_rut;
    private String shipper_email;
    private String shipper_phone;
    private String shipper_address;
    private String consignee_name;
    private String consignee_rut;
    private String consignee_email;
    private String consignee_phone;
    private String consignee_address;
    private String notify_address;
    private String country_origin;
    private String bill_of_lading;
    private String type_of_service;
    private String ocean_vessel;
    private String freight_details;
    private String total_prepaid;
    private String total_collect;
    //private String cargo_insurance;
    private String place_of_issue;
    private LocalDate date_of_issue;
    private Integer number_of_original_BL;
    private String port_loading;
    private String port_discharge;
    private String place_receipt;
    private String place_delivery;
    private Float gross_weight;
    private Float measurement;
    private String marks_and_numbers;
    private String container_number;
    private String security_seal;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_package")
    private PackagesEntity packages;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_for_delivery")
    private ForDeliveryEntity for_delivery;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_exportacion")
    private RegistroExportacionEntity registroExportacion;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_importacion")
    private RegistroImportacionEntity registroImportacion;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;


}
