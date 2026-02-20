package com.airline.domain.model;

import com.airline.domain.enums.RoleEnum;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Role implements Serializable {

    Long idRole;
    RoleEnum roleEnum;
    Set<Permission> permissions = new HashSet<>();

}
