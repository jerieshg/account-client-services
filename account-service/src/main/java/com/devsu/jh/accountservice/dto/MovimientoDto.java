package com.devsu.jh.accountservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class MovimientoDto {
    private Long movimientoId;
    private Long cuentaId;
    private LocalDate fecha;
    private String tipoDeMovimiento;
    private BigDecimal valor;
}

