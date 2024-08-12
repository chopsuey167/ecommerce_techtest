package com.inditex.ecommerce.infrastructure.rest.exception;

import com.inditex.ecommerce.infrastructure.adapter.exception.PriceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(PriceNotFoundException.class)
  public ResponseEntity<?> handlePriceNotFoundException() {
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}
