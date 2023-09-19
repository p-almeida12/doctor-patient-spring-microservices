package com.palmeida.doctorservice.entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullDoctorResponse {

    private String firstName;
    private String lastName;
    List<Pacient> pacients;
}
