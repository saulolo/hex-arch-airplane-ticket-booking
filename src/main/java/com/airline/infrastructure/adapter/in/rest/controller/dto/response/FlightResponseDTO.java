package com.airline.infrastructure.adapter.in.rest.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;

import java.time.LocalDateTime;

/**
 * DTO de respuesta para los detalles de un vuelo.
 * Se usa para mostrar los resultados de la búsqueda de vuelos a los clientes.
 */
@Builder
@JsonPropertyOrder({"idFlight", "flightNumber", "origin", "destination", "departureTime", "arrivalTime"})
public record FlightResponseDTO(
        Long idFlight,
        String flightNumber,
        String origin,
        String destination,
        LocalDateTime departureTime,
        LocalDateTime arrivalTime) {
}
