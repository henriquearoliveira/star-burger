package com.startup.burger.handler;

import com.startup.burger.exceptions.BurgerException;
import com.startup.burger.exceptions.ErrorDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(BurgerException.class)
    public ResponseEntity<ErrorDetail> objetoComDependenciaException(BurgerException e) {

        ErrorDetail errorDetail = new ErrorDetail.Builder()
                .setDetail(e.getMessage())
                .setTimestamp(LocalDateTime.now())
                .setStatus(e.getHttpStatus().value())
                .setDeveloperMessage(e.getClass().getName())
                .build();

        return ResponseEntity.status(e.getHttpStatus()).body(errorDetail);

    }

}
