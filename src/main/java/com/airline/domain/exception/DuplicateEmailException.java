package com.airline.domain.exception;

/**
 * Se produjo una excepción al intentar registrar un correo electrónico duplicado.
 */
public class DuplicateEmailException extends RuntimeException {

    /**
     * Constructor con mensaje personalizado.
     *
     * @param message mensaje descriptivo del recurso no encontrado
     */
    public DuplicateEmailException(String message) {
        super(message);
    }

}
