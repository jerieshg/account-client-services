package com.devsu.jh.accountservice.mapper;

import com.devsu.jh.accountservice.dto.MovimientoDto;
import com.devsu.jh.accountservice.entity.Movimiento;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovimientoMapper {

    MovimientoDto toDto(Movimiento entity);

    Movimiento toEntity(MovimientoDto entity);

    List<MovimientoDto> toList(List<Movimiento> cuentas);
}
