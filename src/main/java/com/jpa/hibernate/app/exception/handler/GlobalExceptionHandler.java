package com.jpa.hibernate.app.exception.handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

  private final Logger logger = LogManager.getLogger(this.getClass());

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(TypeMismatchException.class)
  public ResponseEntity<String> handleTypeMismatchException(Exception exception) {
    logger.warn("Arg validation error: {}", exception.getMessage(), exception);
    return new ResponseEntity<>("{\"error\" : \"ID not valid\"}", HttpStatus.BAD_REQUEST);
  }
}
