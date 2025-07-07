package com.tracker.money_tracker.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "cuenta")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(table = "nombre_cuenta", nullable = false, unique = true)
    private String nombreCuenta;

    @Column(table = "tipo_cuenta", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoCuenta tipoCuenta;

    @Column(table = "fecha_creacion", nullable = false)
    private LocalDate fechaCreacion;

    @Column(table = "bal_inicial", nullable = false)
    private Double balanceInicial;

    @Column(table = "bal_actual", nullable = false)
    private Double balanceActual;

    @Column(table = "limite_credito", nullable = false)
    private Double limiteCredito;

    @Column(table = "descripcion")
    private String descripcion;

    @Column(table = "es_predeterminada")
    private Boolean esPredeterminada;

    @Enumerated(EnumType.STRING)
    @Column(table = "estado", nullable = false)
    private Estado estado;

    @Enumerated(EnumType.STRING)
    @Column(table = "moneda", nullable = false)
    private Moneda moneda;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

}
