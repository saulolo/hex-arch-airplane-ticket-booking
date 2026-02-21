package com.airline.domain.exception;

/**
 * Excepción lanzada cuando no se encuentra un recurso solicitado.
 * Mapea a HTTP 404 NOT FOUND.
 */
public class ResourceNotFoundException extends RuntimeException {


    /**
     * Constructor con mensaje personalizado.
     *
     * @param message mensaje descriptivo del recurso no encontrado
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }

}
