package com.devsu.jh.accountservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    @Column(name = "NUMERO_DE_CUENTA", unique = true)
    private Long numeroDeCuenta;
    @Column(name = "ACCOUNT_TYPE")
    private String accountType;
    @Column(name = "SALDO")
    private BigDecimal saldo;
    @Column(name = "STATUS")
    private boolean status;
    @Column(name = "CLIENTE_ID", unique = true)
    private Long clienteId;
}

