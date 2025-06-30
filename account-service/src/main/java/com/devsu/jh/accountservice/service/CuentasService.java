package com.devsu.jh.accountservice.service;

import com.devsu.jh.accountservice.dto.CuentaDto;
import com.devsu.jh.accountservice.entity.Cuenta;
import com.devsu.jh.accountservice.exception.NotFoundException;
import com.devsu.jh.accountservice.mapper.CuentaMapper;
import com.devsu.jh.accountservice.repository.CuentaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CuentasService {

    private final CuentaRepository repository;
    private final CuentaMapper cuentaMapper;

    public List<CuentaDto> retrieveCuentas() {
        return cuentaMapper.toList(repository.findActiveCuentas());
    }

    public CuentaDto retrieveCuentaById(Long id) {
        return cuentaMapper.toDto(
                repository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Cuenta with id %s is not found", id)))
        );
    }

    public CuentaDto createCuenta(CuentaDto CuentaDto) {
        Cuenta Cuenta = cuentaMapper.toEntity(CuentaDto);
        return cuentaMapper.toDto(repository.save(Cuenta));
    }

    public CuentaDto updateCuenta(Long id, CuentaDto cuentaDto) {
        log.info("Updating client with id {}", id);
        Cuenta Cuenta = cuentaMapper.toEntity(cuentaDto);
        Cuenta.setCuentaId(id);
        return cuentaMapper.toDto(repository.save(Cuenta));
    }

    public void removeCuenta(Long id) {
        repository.deleteById(id);
        log.info("Deleted client with id {} successfully", id);
    }
}
