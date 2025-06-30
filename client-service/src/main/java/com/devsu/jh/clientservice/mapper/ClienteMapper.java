package com.devsu.jh.clientservice.mapper;

import com.devsu.jh.clientservice.dto.ClienteDto;
import com.devsu.jh.clientservice.entity.Cliente;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    ClienteDto toDto(Cliente cliente);

    Cliente toEntity(ClienteDto clienteDto);

    List<ClienteDto> toList(List<Cliente> clientes);
}
