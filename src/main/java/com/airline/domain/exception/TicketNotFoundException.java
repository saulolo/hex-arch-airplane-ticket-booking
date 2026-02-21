package com.airline.domain.exception;

/**
 * Se lanza una excepción cuando no se encuentra un ticket.
 */
public class TicketNotFoundException extends RuntimeException {


    /**
     * Constructor con mensaje personalizado.
     *
     * @param message mensaje descriptivo del recurso no encontrado
     */
    public TicketNotFoundException(String message) {
        super(message);
    }

}
