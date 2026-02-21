package com.airline.infrastructure.exception;

import org.springframework.http.HttpStatus;

import static com.airline.infrastructure.util.Constants.BAD_REQUEST;

/**
 * Excepción para solicitudes inválidas (400).
 */
public class BadRequestException extends ApiException{

    /**
     * Constructor con mensaje de error.
     *
     * @param message descripción del error
     */
    public BadRequestException(String message) {
        super(message, HttpStatus.BAD_REQUEST, BAD_REQUEST);
    }

    /**
     * Constructor con mensaje y causa raíz.
     *
     * @param message descripción del error
     * @param cause   excepción original que causó el error
     */
    public BadRequestException(String message, Throwable cause) {
        super(message, HttpStatus.BAD_REQUEST, BAD_REQUEST, cause);
    }
}
