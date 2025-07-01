package com.devsu.jh.accountservice.repository;

import com.devsu.jh.accountservice.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
    @Query(value = "SELECT cuenta FROM Cuenta cuenta WHERE cuenta.status = true")
    List<Cuenta> findActiveCuentas();

    List<Cuenta> findByClienteId(Long clientId);
}
