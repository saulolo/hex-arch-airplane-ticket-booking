package com.airline.domain.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ticket {

    Long idTicket;
    String ticketNumber;
    BigDecimal price;
    @Builder.Default
    boolean isAvailable = true;
    String description;
    LocalDateTime createdDate;
    Flight flight;
    Reservation reservation;

}
