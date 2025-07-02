package com.devsu.jh.accountservice.controller;

import com.devsu.jh.accountservice.dto.EstadoCuentaDto;
import com.devsu.jh.accountservice.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reportes")
public class ReportController {

    private final ReportService reportService;

    @GetMapping()
    public List<EstadoCuentaDto> createEstadoDeCuenta(@RequestParam("cliente") Long clienteId,
                                                      @RequestParam("startDate") LocalDate startDate,
                                                      @RequestParam("endDate") LocalDate endDate) {
        return reportService.createEstadoDeCuenta(clienteId, startDate, endDate);
    }
}
