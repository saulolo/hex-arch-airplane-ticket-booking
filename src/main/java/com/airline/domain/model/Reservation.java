package com.airline.domain.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Reservation {

    Long idReservation;
    String reservationCode;
    String description;
    LocalDateTime createdDate;
    boolean isCancelled;
    User user;
    Ticket ticket;

}
