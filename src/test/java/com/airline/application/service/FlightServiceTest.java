package com.airline.application.service;

import com.airline.domain.model.Flight;
import com.airline.domain.port.out.FlightRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.airline.data.DataDummy.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("FlightServiceTest - Pruebas Unitarias")
class FlightServiceTest {

    @Mock
    private FlightRepositoryPort flightRepositoryPort;

    @InjectMocks
    private FlightService flightService;

    private Flight flight;

    @BeforeEach
    void setUp() {
        flight = baseFlightBuilder();
    }


    @Test
    @DisplayName("Debería retornar vuelos por origen y destino correctamente")
    void findByOriginAndDestination() {
        // Given
        List<Flight> expectedFlights = getFlightDummyList();
        when(flightRepositoryPort.findByOriginAndDestination(DEFAULT_ORIGIN, DEFAULT_DESTINATION))
                .thenReturn(expectedFlights);

        //When
        List<Flight> result = flightService.findByOriginAndDestination(DEFAULT_ORIGIN, DEFAULT_DESTINATION);

        //Then
        assertNotNull(result, "La lista no puede ser nula.");
        assertEquals(1, result.size());
        assertEquals(flight.getFlightNumber(), result.getFirst().getFlightNumber());
        verify(flightRepositoryPort).findByOriginAndDestination(DEFAULT_ORIGIN, DEFAULT_DESTINATION);
    }
}