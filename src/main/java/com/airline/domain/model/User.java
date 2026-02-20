package com.airline.domain.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    Long idUser;
    String name;
    String lastname;
    String email;
    String phoneNumber;
    String username;
    String password;
    boolean isEnabled = true;
    boolean accountNoExpired = true;
    boolean accountNoLocked = true;
    boolean credentialNoExpired = true;
    String description;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    List<Reservation> reservations;
    Set<Role> roles = new HashSet<>();

}
