package com.tracker.money_tracker.model.entities;

import com.tracker.money_tracker.model.DTOs.UsuarioDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "usuarios")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre",nullable = false)
    private String nombre;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "fec_registro", nullable = false)
    private LocalDate fechaRegistro;

    @Column(name = "pais", nullable = false)
    private String pais;

    @Enumerated(EnumType.STRING)
    @Column(name = "rol", nullable = false)
    private Rol rol;

    @Column(name = "es_activo", nullable = false)
    private Boolean esActivo;

    public Usuario(UsuarioDTO usuarioDTO) {
        this.nombre = usuarioDTO.nombre();
        this.email = usuarioDTO.email();
        this.password = usuarioDTO.password();
        this.fechaRegistro = LocalDate.now();
        this.pais = usuarioDTO.pais();
        this.rol = Rol.USER;
        this.esActivo = true;
    }

}
