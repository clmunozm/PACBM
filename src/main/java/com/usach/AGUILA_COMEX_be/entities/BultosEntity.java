package com.usach.AGUILA_COMEX_be.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bultos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BultosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String type;
    private Integer quantity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_registro_importacion")
    private RegistroImportacionEntity registroImportacion;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_registro_exportacion")
    private RegistroExportacionEntity registroExportacion;
}
