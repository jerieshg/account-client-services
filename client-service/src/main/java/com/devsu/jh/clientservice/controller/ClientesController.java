package com.devsu.jh.clientservice.controller;

import com.devsu.jh.clientservice.dto.ClienteDto;
import com.devsu.jh.clientservice.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clientes")
public class ClientesController {

    private final ClienteService clienteService;

    @GetMapping
    public List<ClienteDto> findActiveClientes() {
        return clienteService.retrieveClientes();
    }

    @GetMapping("/{clienteId}")
    public ClienteDto retrieveClienteById(@PathVariable("clienteId") Long clienteId) {
        return clienteService.retrieveClienteById(clienteId);
    }

    @PostMapping
    public ClienteDto createCliente(@RequestBody ClienteDto clienteDto) {
        return clienteService.createCliente(clienteDto);
    }

    @PutMapping("/{clienteId}")
    public ClienteDto updateCliente(@PathVariable("clienteId") Long clienteId, @RequestBody ClienteDto clienteDto) {
        return clienteService.updateCliente(clienteDto, clienteId);
    }

    @DeleteMapping("/{clienteId}")
    public void removeCliente(@PathVariable("clienteId") Long clienteId) {
        clienteService.removeCliente(clienteId);
    }
}
