package com.devsu.jh.clientservice.service;

import com.devsu.jh.clientservice.dto.ClienteDto;
import com.devsu.jh.clientservice.entity.Cliente;
import com.devsu.jh.clientservice.exception.NotFoundException;
import com.devsu.jh.clientservice.mapper.ClienteMapper;
import com.devsu.jh.clientservice.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public List<ClienteDto> retrieveClientes() {
        return clienteMapper.toList(clienteRepository.findActiveClientes());
    }

    public ClienteDto retrieveClienteById(Long id) {
        return clienteMapper.toDto(
                clienteRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Cliente with id %s is not found", id)))
        );
    }

    public ClienteDto createCliente(ClienteDto clienteDto) {
        Cliente cliente = clienteMapper.toEntity(clienteDto);
        return clienteMapper.toDto(clienteRepository.save(cliente));
    }

    public ClienteDto updateCliente(ClienteDto clienteDto, Long clienteId) {
        log.info("Updating client with id {}", clienteId);
        Cliente cliente = clienteMapper.toEntity(clienteDto);
        cliente.setClienteId(clienteId);
        return clienteMapper.toDto(clienteRepository.save(cliente));
    }

    public void removeCliente(Long clienteId) {
        clienteRepository.deleteById(clienteId);
        log.info("Deleted client with id {} successfully", clienteId);
    }
}
