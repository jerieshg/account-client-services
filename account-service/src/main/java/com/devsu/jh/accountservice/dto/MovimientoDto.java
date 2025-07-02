package com.devsu.jh.accountservice.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class MovimientoDto {
    private Long movimientoId;
    @NotNull
    private Long numeroDeCuenta;
    private LocalDate fecha;
    @NotNull
    private String tipoDeMovimiento;
    @NotNull
    private BigDecimal saldoInicial;
    private BigDecimal valor;
}

