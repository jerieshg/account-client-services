package com.devsu.jh.accountservice.controller;

import com.devsu.jh.accountservice.dto.MovimientoDto;
import com.devsu.jh.accountservice.service.MovimientoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movimientos")
public class MovimientosController {

    private final MovimientoService movimientoService;

    @GetMapping("/{cuenta}")
    public List<MovimientoDto> retrieveByCuentaById(@PathVariable("cuenta") Long cuenta) {
        return movimientoService.retrieveMovimientoByCuentas(cuenta);
    }

    @PostMapping
    public MovimientoDto registerMovimiento(@Valid @RequestBody MovimientoDto movimientoDto) {
        return movimientoService.registrarMovimiento(movimientoDto);
    }

    @PutMapping("/{movimientoId}")
    public MovimientoDto updateMovimiento(@PathVariable("movimientoId") Long movimientoId, @Valid @RequestBody MovimientoDto movimientoDto) {
        return movimientoService.updateMovimiento(movimientoId, movimientoDto);
    }

    @DeleteMapping("/{movimientoId}")
    public void removeCuenta(@PathVariable("movimientoId") Long movimientoId) {
        movimientoService.removeMovimiento(movimientoId);
    }
}
