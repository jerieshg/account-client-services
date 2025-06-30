package com.devsu.jh.clientservice.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "CLIENTES")
@EqualsAndHashCode(callSuper = true)
public class Cliente extends Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLIENT_ID")
    private Long clienteId;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "STATUS")
    private boolean status;
}

