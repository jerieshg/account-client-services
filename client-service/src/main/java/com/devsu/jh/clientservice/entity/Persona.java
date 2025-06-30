package com.devsu.jh.clientservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@MappedSuperclass
public class Persona {

    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "GENERO")
    private String genero;
    @Column(name = "EDAD")
    private int edad;
    @Column(name = "IDENTIFICACION")
    private String identificacion;
    @Column(name = "DIRECCION")
    private String direccion;
    @Column(name = "TELEFONO")
    private String telefono;
}

