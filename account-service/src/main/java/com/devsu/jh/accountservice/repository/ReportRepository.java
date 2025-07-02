package com.devsu.jh.accountservice.repository;

import com.devsu.jh.accountservice.dto.EstadoCuentaDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public class ReportRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<EstadoCuentaDto> generateEstadoDeCuenta(Long clienteId, LocalDate startDate, LocalDate endDate) {
        var query = entityManager.createNativeQuery("""
                SELECT mov.fecha, cl.nombre, cuenta.numero_de_cuenta, cuenta.account_type, mov.saldo_inicial, cuenta.status, mov.valor, mov.saldo_inicial + mov.valor
                FROM clientes cl
                LEFT JOIN cuentas cuenta on cuenta.cliente_id = cl.cliente_id
                LEFT JOIN movimientos mov on mov.numero_de_cuenta = cuenta.numero_de_cuenta
                WHERE cl.cliente_id = :clientId
                AND mov.fecha BETWEEN :startDate AND :endDate
                ORDER BY mov.fecha
                """);
        query.setParameter("clientId", clienteId);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);

        return hydrateDto(query.getResultList());
    }

    public List<EstadoCuentaDto> hydrateDto(List<Object[]> results) {
        return results.stream()
                .map(result -> new EstadoCuentaDto(
                        LocalDate.parse(result[0].toString()),
                        (String) result[1],
                        (Long) result[2],
                        (String) result[3],
                        (BigDecimal) result[4],
                        (Boolean) result[5],
                        (BigDecimal) result[6],
                        (BigDecimal) result[7]
                ))
                .toList();
    }
}
