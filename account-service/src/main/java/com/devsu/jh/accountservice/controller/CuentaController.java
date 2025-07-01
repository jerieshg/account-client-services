package com.devsu.jh.accountservice.controller;

import com.devsu.jh.accountservice.dto.CuentaDto;
import com.devsu.jh.accountservice.service.CuentasService;
import jakarta.validation.Valid;
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

    @GetMapping("/{cuenta}")
    public CuentaDto retrieveCuentaByNumeroDeCuenta(@PathVariable("cuenta") Long cuenta) {
        return cuentasService.retrieveCuentaByNumDeCuenta(cuenta);
    }

    @GetMapping("/clientes/{clientId}")
    public List<CuentaDto> retreiveByClient(@PathVariable("clientId") Long clientId) {
        return cuentasService.retrieveByClientId(clientId);
    }

    @PostMapping
    public CuentaDto createCuenta(@Valid @RequestBody CuentaDto cuentaDto) {
        return cuentasService.createCuenta(cuentaDto);
    }

    @PutMapping
    public CuentaDto updateCuenta(@Valid @RequestBody CuentaDto cuentaDto) {
        return cuentasService.updateCuenta(cuentaDto);
    }

    @DeleteMapping("/{cuentaId}")
    public void removeCuenta(@PathVariable("cuentaId") Long cuentaId) {
        cuentasService.removeCuenta(cuentaId);
    }
}
