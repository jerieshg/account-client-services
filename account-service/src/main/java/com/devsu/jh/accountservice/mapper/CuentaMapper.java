package com.devsu.jh.accountservice.mapper;

import com.devsu.jh.accountservice.dto.CuentaDto;
import com.devsu.jh.accountservice.entity.Cuenta;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CuentaMapper {

    CuentaDto toDto(Cuenta entity);

    Cuenta toEntity(CuentaDto entity);

    List<CuentaDto> toList(List<Cuenta> cuentas);
}
