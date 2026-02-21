package com.airline.application.service;

import com.airline.domain.model.Flight;
import com.airline.domain.port.in.FlightUseCasePort;
import com.airline.domain.port.out.FlightRepositoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class FlightService implements FlightUseCasePort {

    private final FlightRepositoryPort flightRepositoryPort;

    /**
     * Busca una lista de vuelos por su origen y destino.
     * @param origin      El punto de partida del vuelo.
     * @param destination El punto de llegada del vuelo.
     * @return Lista de vuelos que coinciden con el origen y destino especificados.
     * @see FlightUseCasePort
     */
    @Override
    public List<Flight> findByOriginAndDestination(String origin, String destination) {
        log.info("Buscando vuelos de: {} a {}.", origin, destination);
        return flightRepositoryPort.findByOriginAndDestination(origin, destination);
    }
}
