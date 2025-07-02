package com.devsu.jh.accountservice.service;

import com.devsu.jh.accountservice.mapper.MovimientoMapper;
import com.devsu.jh.accountservice.repository.MovimientoRepository;
import com.devsu.jh.accountservice.util.EntityUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MovimientoServiceTest {

    @Mock
    private MovimientoRepository repository;
    @Mock
    private CuentasService cuentasService;
    private MovimientoService movimientoService;
    private MovimientoMapper movimientoMapper = Mappers.getMapper(MovimientoMapper.class);

    @BeforeEach
    public void setup() {
        movimientoService = new MovimientoService(repository, movimientoMapper, cuentasService);
    }

    @Test
    void shouldSaveMovimientoSuccessfully() {
        var cuenta = EntityUtils.buildCuentaDto();
        when(cuentasService.retrieveCuentaByNumDeCuenta(any())).thenReturn(cuenta);
        var expected = EntityUtils.buildDepositoMovimientoDto(cuenta.getClienteId());
        expected.setSaldoInicial(cuenta.getSaldo());
        expected.setTipoDeMovimiento("Deposito de %s".formatted(expected.getValor()));
        when(repository.save(any())).thenReturn(movimientoMapper.toEntity(expected));

        var result = movimientoService.registrarMovimiento(expected);
        assertEquals(String.format("Deposito de %s", expected.getValor()), result.getTipoDeMovimiento());
        assertEquals(BigDecimal.valueOf(1000L), result.getSaldoInicial());
    }
}
