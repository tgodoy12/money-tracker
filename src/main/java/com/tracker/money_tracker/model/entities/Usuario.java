package com.tracker.money_tracker.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "user")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(table = "nombre",nullable = false)
    private String nombre;

    @Column(table = "email", unique = true, nullable = false)
    private String email;

    @Column(table = "password", nullable = false)
    private String password;

    @Column(table = "fec_registro", nullable = false)
    private LocalDate fechaRegistro;

    @Column(table = "pais", nullable = false)
    private String pais;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    @Column(table = "es_activo", nullable = false)
    private Boolean esActivo;



}
