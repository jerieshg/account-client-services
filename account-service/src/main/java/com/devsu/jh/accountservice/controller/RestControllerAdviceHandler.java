package com.devsu.jh.accountservice.controller;

import com.devsu.jh.accountservice.exception.BadRequestException;
import com.devsu.jh.accountservice.exception.InsufficientFundsException;
import com.devsu.jh.accountservice.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@Slf4j
@RestControllerAdvice
public class RestControllerAdviceHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NotFoundException.class})
    public Map<String, String> notFoundException(NotFoundException notFoundException) {
        return generateResponse(notFoundException);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({BadRequestException.class, InsufficientFundsException.class})
    public Map<String, String> badRequestException(Exception exception) {
        return generateResponse(exception);
    }

    @ExceptionHandler({Exception.class})
    public Map<String, String> catchAllExceptions(Exception ex) {
        log.error(ex.getMessage(), ex);
        return generateResponse(ex);
    }

    private Map<String, String> generateResponse(Exception exception) {
        return Map.of("message", exception.getMessage());
    }
}
