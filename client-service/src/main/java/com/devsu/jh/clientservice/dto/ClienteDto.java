package com.devsu.jh.clientservice.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDto {
    private Long clienteId;
    @NotNull
    private String nombre;
    private String genero;
    private int edad;
    @NotNull
    private String identificacion;
    @NotNull
    private String direccion;
    @NotNull
    private String telefono;
    @NotNull
    private String password;
    private boolean status;
}
