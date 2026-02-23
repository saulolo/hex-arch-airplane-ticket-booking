package com.airline.infrastructure.config;

import com.airline.application.service.FlightService;
import com.airline.domain.port.in.FlightUseCasePort;
import com.airline.domain.port.out.FlightRepositoryPort;
import com.airline.infrastructure.adapter.out.persistence.jpa.FlightRepositoryAdapter;
import com.airline.infrastructure.adapter.out.persistence.jpa.repository.FlightJpaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuración de beans para la capa de aplicación.
 */
@Configuration
public class BeanConfiguration {


    /**
     * Define el bean para el puerto de repositorio de vuelos, inyectando la implementación basada en JPA.
     *
     * @param flightJpaRepository Repositorio JPA para la entidad FlightEntity.
     * @return Implementación del puerto FlightRepositoryPort.
     */
    @Bean
    public FlightRepositoryPort flightRepositoryPort(FlightJpaRepository flightJpaRepository) {
        return new FlightRepositoryAdapter(flightJpaRepository);
    }

    /**
     * Define el bean para el puerto de caso de uso de vuelos, inyectando la implementación del servicio de vuelos.
     *
     * @param flightRepositoryPort Puerto de repositorio de vuelos.
     * @return Implementación del puerto FlightUseCasePort.
     */
    @Bean
    public FlightUseCasePort flightUseCasePort(FlightRepositoryPort flightRepositoryPort) {
        return new FlightService(flightRepositoryPort);
    }

}
