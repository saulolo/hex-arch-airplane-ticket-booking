package com.airline.infrastructure.adapter.out.persistence.jpa.repository;

import com.airline.infrastructure.adapter.out.persistence.jpa.entity.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightJpaRepository extends JpaRepository<FlightEntity, Long> {

    /**
     * Busca una lista de vuelos por su origen y destino.
     *
     * @param origin      El punto de partida del vuelo.
     * @param destination El punto de llegada del vuelo.
     * @return Una lista de vuelos que coinciden con el origen y destino especificados.
     */
    List<FlightEntity> findByOriginIgnoreCaseAndDestinationIgnoreCase(String origin, String destination);

}
