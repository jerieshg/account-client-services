package com.devsu.jh.accountservice.service;

import com.devsu.jh.accountservice.dto.MovimientoDto;
import com.devsu.jh.accountservice.entity.Movimiento;
import com.devsu.jh.accountservice.mapper.MovimientoMapper;
import com.devsu.jh.accountservice.repository.MovimientoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MovimientoService {

    private final MovimientoRepository repository;
    private final MovimientoMapper movimientoMapper;

    public List<MovimientoDto> retrieveMovimientoByCuentas(Long cuentaId) {
        return movimientoMapper.toList(repository.findMovimientosByCuenta(cuentaId));
    }

    public MovimientoDto createMovimiento(MovimientoDto movimientoDto) {
        Movimiento Movimiento = movimientoMapper.toEntity(movimientoDto);
        return movimientoMapper.toDto(repository.save(Movimiento));
    }

    public MovimientoDto updateMovimiento(Long id, MovimientoDto movimientoDto) {
        log.info("Updating client with id {}", id);
        Movimiento Movimiento = movimientoMapper.toEntity(movimientoDto);
        Movimiento.setMovimientoId(id);
        return movimientoMapper.toDto(repository.save(Movimiento));
    }

    public void removeMovimiento(Long id) {
        repository.deleteById(id);
        log.info("Deleted client with id {} successfully", id);
    }
}
