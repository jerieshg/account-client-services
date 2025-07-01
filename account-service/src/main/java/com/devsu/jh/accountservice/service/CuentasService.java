package com.devsu.jh.accountservice.service;

import com.devsu.jh.accountservice.dto.CuentaDto;
import com.devsu.jh.accountservice.exception.BadRequestException;
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

    public CuentaDto retrieveCuentaByNumDeCuenta(Long numeroDeCuenta) {
        return cuentaMapper.toDto(
                repository.findById(numeroDeCuenta).orElseThrow(() -> new NotFoundException(String.format("Cuenta #%s no exista o no esta disponible", numeroDeCuenta)))
        );
    }

    public CuentaDto createCuenta(CuentaDto cuentaDto) {
        if (repository.existsById(cuentaDto.getNumeroDeCuenta())) {
            throw new BadRequestException(String.format("Cuenta #%s existe", cuentaDto.getNumeroDeCuenta()));
        }
        var cuenta = cuentaMapper.toEntity(cuentaDto);
        return cuentaMapper.toDto(repository.save(cuenta));
    }

    public CuentaDto updateCuenta(CuentaDto cuentaDto) {
        log.info("Updating client with id {}", cuentaDto.getNumeroDeCuenta());
        var cuenta = cuentaMapper.toEntity(cuentaDto);
        return cuentaMapper.toDto(repository.save(cuenta));
    }

    public void removeCuenta(Long id) {
        repository.deleteById(id);
        log.info("Deleted client with id {} successfully", id);
    }

    public List<CuentaDto> retrieveByClientId(Long clientId) {
        return cuentaMapper.toList(repository.findByClienteId(clientId));
    }
}
