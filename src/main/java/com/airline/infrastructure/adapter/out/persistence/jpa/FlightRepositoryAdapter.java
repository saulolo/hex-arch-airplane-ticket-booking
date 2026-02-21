package com.airline.infrastructure.adapter.out.persistence.jpa;

import com.airline.domain.model.Flight;
import com.airline.domain.port.out.FlightRepositoryPort;
import com.airline.infrastructure.adapter.out.persistence.jpa.entity.FlightEntity;
import com.airline.infrastructure.adapter.out.persistence.jpa.mapper.FlightMapper;
import com.airline.infrastructure.adapter.out.persistence.jpa.repository.FlightJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FlightRepositoryAdapter implements FlightRepositoryPort {

    private final FlightJpaRepository flightJpaRepository;


    /**
     * Busca vuelos por origen y destino (ignorando mayúsculas)
     * @param origin      El punto de partida del vuelo.
     * @param destination El punto de llegada del vuelo.
     * @return Una lista de vuelos que coinciden con el origen y destino especificados
     */
    @Override
    public List<Flight> findByOriginAndDestination(String origin, String destination) {
        List<FlightEntity> entities = flightJpaRepository.findByOriginIgnoreCaseAndDestinationIgnoreCase(origin, destination);
        return FlightMapper.toDomainList(entities);
    }
}
