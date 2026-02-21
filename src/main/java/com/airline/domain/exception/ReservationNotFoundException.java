package com.airline.domain.exception;

/**
 * Se lanza una excepción cuando no se encuentra una reservación.
 */
public class ReservationNotFoundException extends RuntimeException {

    /**
     * Constructor con mensaje personalizado.
     *
     * @param message mensaje descriptivo del recurso no encontrado
     */
    public ReservationNotFoundException(String message) {
        super(message);
    }

}
