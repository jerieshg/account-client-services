package com.devsu.jh.accountservice.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CuentaDto {
    @NotNull
    private Long numeroDeCuenta;
    @NotNull
    private String accountType;
    @NotNull
    private BigDecimal saldo;
    private boolean status;
    @NotNull
    private Long clienteId;
}
