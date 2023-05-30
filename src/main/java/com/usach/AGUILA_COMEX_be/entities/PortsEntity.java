package com.usach.AGUILA_COMEX_be.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Ports")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PortsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String country;
    private String name;
    private String code;
}
