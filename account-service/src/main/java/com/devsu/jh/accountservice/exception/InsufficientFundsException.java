package com.devsu.jh.accountservice.exception;

public class InsufficientFundsException extends RuntimeException {

    public InsufficientFundsException(long cuentaId) {
        super(String.format("Saldo no disponible en la cuenta #%s", cuentaId));
    }
}
