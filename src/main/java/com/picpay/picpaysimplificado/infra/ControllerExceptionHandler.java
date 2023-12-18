package com.picpay.picpaysimplificado.infra;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.picpay.picpaysimplificado.dtos.ExceptionDTO;

import jakarta.persistence.EntityNotFoundException;

/**
 * ControllerExceptionHandler
 */
@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity treatDupicateEntity(DataIntegrityViolationException exception) {
        ExceptionDTO dto = new ExceptionDTO("usuário já cadastrado", "400");
        return ResponseEntity.badRequest().body(dto);
    }

    
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity treatNotFoundEntity(EntityNotFoundException exception) {
         return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity treatGeneneral(Exception exception) {
        ExceptionDTO dto = new ExceptionDTO(exception.getMessage(), "500");
        return ResponseEntity.badRequest().body(dto);
    }

}