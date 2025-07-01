package com.devsu.jh.accountservice.controller;

import com.devsu.jh.accountservice.dto.CuentaDto;
import com.devsu.jh.accountservice.dto.MovimientoDto;
import com.devsu.jh.accountservice.service.MovimientoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movimientos")
public class MovimientosController {
    
    private final MovimientoService movimientoService;

    @GetMapping("/{cuentaId}")
    public List<MovimientoDto> retrieveCuentaById(@PathVariable("cuentaId") Long cuentaId) {
        return movimientoService.retrieveMovimientoByCuentas(cuentaId);
    }

    @PostMapping
    public MovimientoDto registerMovimiento(@RequestBody MovimientoDto movimientoDto) {
        return movimientoService.createMovimiento(movimientoDto);
    }

    @PutMapping("/{movimientoId}")
    public MovimientoDto updateMovimiento(@PathVariable("movimientoId") Long movimientoId, @RequestBody MovimientoDto movimientoDto) {
        return movimientoService.updateMovimiento(movimientoId, movimientoDto);
    }

    @DeleteMapping("/{movimientoId}")
    public void removeCuenta(@PathVariable("movimientoId") Long movimientoId) {
        movimientoService.removeMovimiento(movimientoId);
    }
}
