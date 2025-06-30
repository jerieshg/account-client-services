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


@Getter
@Setter
@Entity
@Table(name = "CUENTAS")
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUENTA_ID")
    private Long cuentaId;
    @Column(name = "NUMERO_DE_CUENTA")
    private long numeroDeCuenta;
    @Column(name = "ACCOUNT_TYPE")
    private String accountType;
    @Column(name = "SALDO_INICIAL")
    private BigDecimal saldoInicial;
    @Column(name = "STATUS")
    private boolean status;
    @Column(name = "CLIENTE_ID", unique = true)
    private Long clienteId;
}

