package com.airline.domain.exception;

/**
 * Se lanza una excepción cuando no se encuentra un usuario.
 */
public class UserNotFoundException extends RuntimeException {


    /**
     * Constructor con mensaje personalizado.
     *
     * @param message mensaje descriptivo del recurso no encontrado
     */
    public UserNotFoundException(String message) {
        super(message);
    }

}
