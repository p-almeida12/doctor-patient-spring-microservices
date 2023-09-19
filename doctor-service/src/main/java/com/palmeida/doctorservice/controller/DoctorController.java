package com.palmeida.doctorservice.controller;

import com.palmeida.doctorservice.entity.Doctor;
import com.palmeida.doctorservice.entity.FullDoctorResponse;
import com.palmeida.doctorservice.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveDoctor(@RequestBody Doctor doctor) {
        doctorService.saveDoctor(doctor);
    }

    @GetMapping
    public ResponseEntity<List<Doctor>> findAllDoctors() {
        return ResponseEntity.ok(doctorService.findAllDoctors());
    }

    @GetMapping("/with-pacients/{doctorId}")
    public ResponseEntity<FullDoctorResponse> findAllDoctors(@PathVariable("doctorId") Long doctorId) {
        return ResponseEntity.ok(doctorService.findDoctorsWithPacients(doctorId));
    }

}
