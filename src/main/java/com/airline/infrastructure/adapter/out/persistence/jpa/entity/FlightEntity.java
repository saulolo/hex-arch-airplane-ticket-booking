package com.airline.infrastructure.adapter.out.persistence.jpa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "flights")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FlightEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_flight")
    Long idFlight;

    @Column(name = "flight_number", nullable = false, length = 30)
    String flightNumber;

    @Column(name = "origin", nullable = false, length = 100)
    String origin;

    @Column(name = "destination", nullable = false, length = 100)
    String destination;

    @Column(name = "departure_time", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    LocalDateTime departureTime;

    @Column(name = "arrival_time", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    LocalDateTime arrivalTime;

    //@OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    //@JsonIgnore
    //List<Ticket> tickets; //Ojo, aqui cambiar pot TicketEntity

    @Column(name = "created_at", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    LocalDateTime updatedAt;

}
