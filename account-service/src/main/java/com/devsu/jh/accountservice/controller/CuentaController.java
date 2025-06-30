package com.devsu.jh.accountservice.controller;

import com.devsu.jh.accountservice.dto.CuentaDto;
import com.devsu.jh.accountservice.service.CuentasService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cuentas")
public class CuentaController {

    private final CuentasService cuentasService;

    @GetMapping
    public List<CuentaDto> findCuentas() {
        return cuentasService.retrieveCuentas();
    }

    @GetMapping("/{cuentaId}")
    public CuentaDto retrieveCuentaById(@PathVariable("cuentaId") Long cuentaId) {
        return cuentasService.retrieveCuentaById(cuentaId);
    }

    @PostMapping
    public CuentaDto createCuenta(@RequestBody CuentaDto cuentaDto) {
        return cuentasService.createCuenta(cuentaDto);
    }

    @PutMapping("/{cuentaId}")
    public CuentaDto updateCuenta(@PathVariable("cuentaId") Long cuentaId, @RequestBody CuentaDto cuentaDto) {
        return cuentasService.updateCuenta(cuentaId, cuentaDto);
    }

    @DeleteMapping("/{cuentaId}")
    public void removeCuenta(@PathVariable("cuentaId") Long cuentaId) {
        cuentasService.removeCuenta(cuentaId);
    }
}
