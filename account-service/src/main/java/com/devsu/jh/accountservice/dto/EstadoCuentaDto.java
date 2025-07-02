package com.devsu.jh.accountservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstadoCuentaDto {
    private LocalDate fecha;
    private String cliente;
    private Long numeroDeCuenta;
    private String tipo;
    private BigDecimal saldoInicial;
    private boolean status;
    private BigDecimal movimiento;
    private BigDecimal saldoDisponible;
}
