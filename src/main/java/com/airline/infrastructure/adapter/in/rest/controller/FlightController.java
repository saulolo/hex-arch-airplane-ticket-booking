package com.airline.infrastructure.adapter.in.rest.controller;

import com.airline.domain.port.in.FlightUseCasePort;
import com.airline.infrastructure.adapter.in.rest.controller.dto.response.ApiResponseDTO;
import com.airline.infrastructure.adapter.in.rest.controller.dto.response.FlightResponseDTO;
import com.airline.infrastructure.adapter.in.rest.mapper.FlightRestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.airline.infrastructure.util.Constants.FLIGHTS_NOT_FOUND;
import static com.airline.infrastructure.util.Constants.FLIGHTS_RETRIEVED;

@RestController
@RequiredArgsConstructor
@RequestMapping("/flights")
public class FlightController {

    private final FlightUseCasePort flightUseCasePort;
    private final FlightRestMapper flightRestMapper;

    /**
     * Busca vuelos disponibles por origen y destino.
     *
     * @param origin      El punto de partida del vuelo.
     * @param destination El punto de llegada del vuelo.
     * @return ResponseEntity con la estructura estandarizada de la API, un estado HTTP 200 OK y una lista de vuelos encontrados.
     */
    @GetMapping("/search")
    public ResponseEntity<ApiResponseDTO<List<FlightResponseDTO>>> searchFlights(
            @RequestParam String origin,
            @RequestParam String destination) {

        List<FlightResponseDTO> flights = flightRestMapper.toFlightResponseDTOList(
                flightUseCasePort.findByOriginAndDestination(origin, destination)
        );

        String message = flights.isEmpty() ? FLIGHTS_NOT_FOUND : FLIGHTS_RETRIEVED;

        return ResponseEntity.ok(
                ApiResponseDTO.success(flights, message)
        );
    }

}