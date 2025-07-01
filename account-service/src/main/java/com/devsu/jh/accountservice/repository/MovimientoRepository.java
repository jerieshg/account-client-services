package com.devsu.jh.accountservice.repository;

import com.devsu.jh.accountservice.entity.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
    @Query(value = "SELECT movimiento FROM Movimiento movimiento WHERE movimiento.cuentaId = :cuentaId")
    List<Movimiento> findMovimientosByCuenta(@Param("cuentaId") Long cuentaId);
}
