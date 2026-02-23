package com.airline.infrastructure.adapter.out.persistence.jpa.mapper;

import com.airline.domain.model.Flight;
import com.airline.infrastructure.adapter.out.persistence.jpa.entity.FlightEntity;

import java.util.List;

import static com.airline.infrastructure.util.Constants.NON_INSTANTIABLE_UTILITY_CLASS;


/**
 * Mapper utilitario para convertir entre FlightEntity (persistencia JPA)
 * y Flight (modelo de dominio).
 */
public final class FlightMapper {

    private FlightMapper() {
        throw new UnsupportedOperationException(NON_INSTANTIABLE_UTILITY_CLASS);
    }
    // ========== ENTITY → DOMAIN ==========

    /**
     * Convierte una entidad FlightEntity a un modelo de dominio Flight.
     *
     * @param flightEntity La entidad FlightEntity a convertir.
     * @return El modelo de dominio Flight mapeado.
     */
    public static Flight toDomain(FlightEntity flightEntity) {
        if (flightEntity == null) {
            return null;
        }
        return Flight.builder()
                .idFlight(flightEntity.getIdFlight())
                .flightNumber(flightEntity.getFlightNumber())
                .origin(flightEntity.getOrigin())
                .destination(flightEntity.getDestination())
                .departureTime(flightEntity.getDepartureTime())
                .arrivalTime(flightEntity.getArrivalTime())
                //.tickets(flightEntity.getTickets())
                .createdAt(flightEntity.getCreatedAt())
                .updatedAt(flightEntity.getUpdatedAt())
                .build();

    }

    /**
     * Convierte una lista de entidades FlightEntity a una lista de modelos de dominio Flight.
     *
     * @param entities La lista de entidades FlightEntity a convertir.
     * @return Una lista de modelos de dominio Flight mapeados.
     */
    public static List<Flight> toDomainList(List<FlightEntity> entities) {
        return entities.stream()
                .map(FlightMapper::toDomain)
                .toList();
    }


    // ========== DOMAIN → ENTITY ==========

    /**
     * Convierte un modelo de dominio Flight a una entidad FlightEntity.
     *
     * @param flight El modelo de dominio Flight a convertir.
     * @return La entidad FlightEntity mapeada.
     */
    public static FlightEntity toEntity(Flight flight) {
        if (flight == null) return null;
        return FlightEntity.builder()
                .idFlight(flight.getIdFlight())
                .flightNumber(flight.getFlightNumber())
                .origin(flight.getOrigin())
                .destination(flight.getDestination())
                .departureTime(flight.getDepartureTime())
                .arrivalTime(flight.getArrivalTime())
                //.tickets(flight.getTickets())
                .createdAt(flight.getCreatedAt())
                .updatedAt(flight.getUpdatedAt())
                .build();
    }

    /**
     * Convierte una lista de modelos de dominio Flight a una lista de entidades FlightEntity.
     *
     * @param flights La lista de modelos de dominio Flight a convertir.
     * @return Una lista de entidades FlightEntity mapeadas.
     */
    public static List<FlightEntity> toEntityList(List<Flight> flights) {
        return flights.stream()
                .map(FlightMapper::toEntity)
                .toList();
    }

}
