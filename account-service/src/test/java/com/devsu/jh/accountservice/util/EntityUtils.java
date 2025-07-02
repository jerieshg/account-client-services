package com.devsu.jh.accountservice.util;

import com.devsu.jh.accountservice.dto.CuentaDto;
import com.devsu.jh.accountservice.dto.MovimientoDto;
import com.devsu.jh.accountservice.entity.Cuenta;

import java.math.BigDecimal;

public class EntityUtils {

    public static Cuenta buildCuenta() {
        var cuenta = new Cuenta();
        cuenta.setSaldo(BigDecimal.valueOf(1000));
        cuenta.setStatus(true);
        cuenta.setClienteId(1L);
        cuenta.setAccountType("Savings");
        cuenta.setNumeroDeCuenta(123123L);
        return cuenta;
    }

    public static CuentaDto buildCuentaDto() {
        var cuentaDto = new CuentaDto();
        cuentaDto.setSaldo(BigDecimal.valueOf(1000));
        cuentaDto.setStatus(true);
        cuentaDto.setClienteId(1L);
        cuentaDto.setAccountType("Savings");
        cuentaDto.setNumeroDeCuenta(123123L);
        return cuentaDto;
    }

    public static MovimientoDto buildDepositoMovimientoDto(long cuentaId) {
        var movimiento = new MovimientoDto();
        movimiento.setValor(BigDecimal.valueOf(100));
        movimiento.setNumeroDeCuenta(cuentaId);
        return movimiento;
    }
}
