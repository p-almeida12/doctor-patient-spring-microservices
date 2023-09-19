package com.palmeida.doctorservice.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pacient {

    private String firstName;
    private String lastName;
    private String email;
}
