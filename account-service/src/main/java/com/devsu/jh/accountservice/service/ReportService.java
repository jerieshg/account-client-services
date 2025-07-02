package com.devsu.jh.accountservice.service;

import com.devsu.jh.accountservice.dto.EstadoCuentaDto;
import com.devsu.jh.accountservice.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final ReportRepository repository;

    public List<EstadoCuentaDto> createEstadoDeCuenta(Long clienteId, LocalDate startDate, LocalDate endDate) {
        return repository.generateEstadoDeCuenta(clienteId, startDate, endDate);
    }
}
