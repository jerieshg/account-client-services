package com.devsu.jh.accountservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @Column(name = "VALOR")
    private BigDecimal valor;
    @Column(name = "NUMERO_DE_CUENTA")
    private Long numeroDeCuenta;
}

