package com.devsu.jh.accountservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;


@Getter
@Setter
@Entity
@Table(name = "MOVIMIENTOS")
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOVIMIENTO_ID")
    private Long movimientoId;
    @Column(name = "FECHA")
    private LocalDate fecha;
    @Column(name = "TIPO_DE_MOVIMIENTO")
    private String tipoDeMovimiento;
    @Column(name = "saldo_inicial")
    private BigDecimal saldoInicial;
    @Column(name = "VALOR")
    private BigDecimal valor;
    @Column(name = "NUMERO_DE_CUENTA")
    private Long numeroDeCuenta;

    @PrePersist
    public void prePersist() {
        fecha = LocalDate.now();
    }
}

