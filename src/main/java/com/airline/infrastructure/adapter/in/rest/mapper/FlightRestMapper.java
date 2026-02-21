package com.airline.infrastructure.adapter.in.rest.mapper;

import com.airline.domain.model.Flight;
import com.airline.infrastructure.adapter.in.rest.controller.dto.response.FlightResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Clase utilitaria para el mapeo entre el modelo del dominio Flight a su correspondiente DTO de respuesta FlightResponseDTO.
 */

@Component
public class FlightRestMapper {


    /**
     * Convierte un objeto Flight (dominio) a un DTO de respuesta FlightResponseDTO.
     * @param flight Objeto modelo de dominio Flight a convertir.
     * @return DTO de respuesta FlightResponseDTO mapeado, o null si el input es null.
     */
    public FlightResponseDTO toFlightResponseDTO(Flight flight) {
        if (flight == null) return null;
        return FlightResponseDTO.builder()
                .idFlight(flight.getIdFlight())
                .flightNumber(flight.getFlightNumber())
                .origin(flight.getOrigin())
                .destination(flight.getDestination())
                .departureTime(flight.getDepartureTime())
                .arrivalTime(flight.getArrivalTime())
                .build();
    }

    /**
     * Convierte una lista de objetos Flight a una lista de DTOs de respuesta FlightResponseDTO.
     * @param flights Lista de objetos Flight (modelo de dominio) a convertir.
     * @return Lista de DTOs de respuesta FlightResponseDTO mapeados.
     */
    public List<FlightResponseDTO> toFlightResponseDTOList(List<Flight> flights) {
        return flights.stream()
                .map(this::toFlightResponseDTO)
                .toList();
    }

}
