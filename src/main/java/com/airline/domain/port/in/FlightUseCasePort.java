package com.airline.domain.port.in;

import com.airline.domain.model.Flight;

import java.util.List;

public interface FlightUseCasePort {

    /**
     * Busca una lista de vuelos por su origen y destino.
     *
     * @param origin      El punto de partida del vuelo.
     * @param destination El punto de llegada del vuelo.
     * @return Una lista de vuelos que coinciden con el origen y destino especificados.
     */
    List<Flight> findByOriginAndDestination(String origin, String destination);

}
