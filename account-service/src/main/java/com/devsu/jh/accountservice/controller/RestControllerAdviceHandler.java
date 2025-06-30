package com.devsu.jh.accountservice.controller;

import com.devsu.jh.accountservice.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@Slf4j
@RestControllerAdvice
public class RestControllerAdviceHandler {

    @ExceptionHandler({NotFoundException.class})
    public Map<String, String> notFoundException(NotFoundException notFoundException) {
        return Map.of("message", notFoundException.getMessage());
    }

    @ExceptionHandler({Exception.class})
    public Map<String, String> catchAllExceptions(Exception ex) {
        log.error(ex.getMessage(), ex);
        return Map.of("message", ex.getMessage());
    }
}
