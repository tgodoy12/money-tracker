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

    @Column(name = "nom_cuenta", nullable = false, unique = true)
    private String nombreCuenta;

    @Column(name = "tipo_cuenta", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoCuenta tipoCuenta;

    @Column(name = "fec_creacion", nullable = false)
    private LocalDate fechaCreacion;

    @Column(name = "bal_inicial", nullable = false)
    private Double balanceInicial;

    @Column(name = "bal_actual", nullable = false)
    private Double balanceActual;

    @Column(name = "limite_credito", nullable = false)
    private Double limiteCredito;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "es_predeterminada")
    private Boolean esPredeterminada;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private Estado estado;

    @Enumerated(EnumType.STRING)
    @Column(name = "moneda", nullable = false)
    private Moneda moneda;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

}
