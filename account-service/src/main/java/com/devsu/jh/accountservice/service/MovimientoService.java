package com.devsu.jh.accountservice.service;

import com.devsu.jh.accountservice.dto.MovimientoDto;
import com.devsu.jh.accountservice.exception.InsufficientFundsException;
import com.devsu.jh.accountservice.mapper.MovimientoMapper;
import com.devsu.jh.accountservice.repository.MovimientoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MovimientoService {

    private final MovimientoRepository repository;
    private final MovimientoMapper movimientoMapper;
    private final CuentasService cuentasService;

    public List<MovimientoDto> retrieveMovimientoByCuentas(Long cuenta) {
        return movimientoMapper.toList(repository.findByNumeroDeCuenta(cuenta));
    }

    public MovimientoDto registrarMovimiento(MovimientoDto movimientoDto) {
        var cuenta = cuentasService.retrieveCuentaByNumDeCuenta(movimientoDto.getNumeroDeCuenta());
        var saldoActualizado = cuenta.getSaldo().add(movimientoDto.getValor());

        if (saldoActualizado.compareTo(BigDecimal.ZERO) < 0) {
            log.info("La cuenta #{} no tiene fondos suficientes", movimientoDto.getNumeroDeCuenta());
            throw new InsufficientFundsException(movimientoDto.getNumeroDeCuenta());
        }

        movimientoDto.setSaldoInicial(cuenta.getSaldo());
        movimientoDto.setTipoDeMovimiento(movimientoDto.getValor().compareTo(BigDecimal.ZERO) < 0
                ? "Retiro de %s".formatted(Math.abs(movimientoDto.getValor().doubleValue()))
                : "Deposito de %s".formatted(movimientoDto.getValor())
        );

        cuenta.setSaldo(saldoActualizado);
        var movimiento = movimientoMapper.toEntity(movimientoDto);
        var result = movimientoMapper.toDto(repository.save(movimiento));
        cuentasService.updateCuenta(cuenta);
        return result;
    }

    public MovimientoDto updateMovimiento(Long movimientoId, MovimientoDto movimientoDto) {
        log.info("Updating client with id {}", movimientoId);
        var movimiento = movimientoMapper.toEntity(movimientoDto);
        movimiento.setMovimientoId(movimientoId);
        return movimientoMapper.toDto(repository.save(movimiento));
    }

    public void removeMovimiento(Long id) {
        repository.deleteById(id);
        log.info("Deleted client with id {} successfully", id);
    }
}
