package com.startup.burger.exceptions;

import org.springframework.http.HttpStatus;

public class BurgerException extends RuntimeException {
    private static final long serialVersionUID = -8697787632237739440L;

    private HttpStatus httpStatus;

    public BurgerException(String mensagem, HttpStatus httpStatus) {
        super(mensagem);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
