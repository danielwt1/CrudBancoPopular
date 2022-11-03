package com.crud.bancopopular.crudbancopopular.exception;


import com.crud.bancopopular.crudbancopopular.model.dto.ErrorDetalles;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetalles> resourceNotFoundExceptionHandler(ResourceNotFoundException ex, WebRequest webRequest) {
        ErrorDetalles errorDetalles = new ErrorDetalles(LocalDateTime.now(), ex.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetalles, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetalles> globalExceptionHandlerr(Exception ex, WebRequest webRequest) {
        ErrorDetalles errorDetalles = new ErrorDetalles(LocalDateTime.now(), ex.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetalles, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(FechaIngresoErrorException.class)
    public ResponseEntity<ErrorDetalles> fechaIngresoExceptionHandlerr(FechaIngresoErrorException ex, WebRequest webRequest) {
        ErrorDetalles errorDetalles = new ErrorDetalles(LocalDateTime.now(), ex.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetalles, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(SolicitudException.class)
    public ResponseEntity<ErrorDetalles> soliciTudExceptionHandlerr(SolicitudException ex, WebRequest webRequest) {
        ErrorDetalles errorDetalles = new ErrorDetalles(LocalDateTime.now(), ex.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetalles, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = ex.getBindingResult().getFieldErrors().stream().map(el -> el.getField() + ": " + el.getDefaultMessage())
                .collect(Collectors.joining(", "));
        ErrorDetalles res = new ErrorDetalles(LocalDateTime.now(), message, request.getDescription(false));
        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }
}
