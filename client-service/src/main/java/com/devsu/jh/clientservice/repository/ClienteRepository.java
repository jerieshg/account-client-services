package com.devsu.jh.clientservice.repository;


import com.devsu.jh.clientservice.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    @Query(value = "SELECT cliente FROM Cliente cliente WHERE cliente.status = true")
    List<Cliente> findActiveClientes();
}
