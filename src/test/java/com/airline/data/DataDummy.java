package com.airline.data;

import com.airline.domain.model.Flight;
import com.airline.domain.model.Ticket;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public class DataDummy {

    // ========== Valores por defecto ==========
    public static final Long DEFAULT_ID = 1L;
    public static final String DEFAULT_FLIGHT_NUMBER = "FL123test";
    public static final String DEFAULT_ORIGIN = "BOGOTÁtest";
    public static final String DEFAULT_DESTINATION = "MEDELLÍNtest";
    public static final LocalDateTime DEFAULT_DEPARTURE_TIME = LocalDateTime.of(2026, 2, 19, 10, 0);
    public static final LocalDateTime DEFAULT_ARRIVAL_TIME = LocalDateTime.of(2026, 2, 19, 12, 0);
    public static final List<Ticket> DEFAULT_TICKETS = Collections.emptyList();
    public static final LocalDateTime DEFAULT_CREATED_AT = LocalDateTime.of(2026, 2, 20, 11, 0);
    public static final LocalDateTime DEFAULT_UPDATED_AT = LocalDateTime.of(2026, 2, 20, 10, 0);



    /**
     * Genera una instancia de {@link Flight} con valores dummy por defecto para pruebas unitarias.
     * @return objeto {@link Flight} preconfigurado con datos de prueba estándar.
     */
    public static Flight baseFlightBuilder() {
        return Flight.builder()
                .idFlight(DEFAULT_ID)
                .flightNumber(DEFAULT_FLIGHT_NUMBER)
                .origin(DEFAULT_ORIGIN)
                .destination(DEFAULT_DESTINATION)
                .departureTime(DEFAULT_DEPARTURE_TIME)
                .arrivalTime(DEFAULT_ARRIVAL_TIME)
                .tickets(DEFAULT_TICKETS)
                .createdAt(DEFAULT_CREATED_AT)
                .updatedAt(DEFAULT_UPDATED_AT)
                .build();
    }


    /**
     * Devuelve una lista con un vuelo dummy para pruebas unitarias.
     *
     * @return lista con un solo objeto {@link Flight} dummy
     */
    public static List<Flight> getFlightDummyList() {
        return Collections.singletonList(baseFlightBuilder());
    }

}

