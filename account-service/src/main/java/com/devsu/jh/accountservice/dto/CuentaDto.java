package com.devsu.jh.accountservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CuentaDto {
    private Long cuentaId;
    private long numeroDeCuenta;
    private String accountType;
    private BigDecimal saldoInicial;
    private boolean status;
    private Long clienteId;
}
