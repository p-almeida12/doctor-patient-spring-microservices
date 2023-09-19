package com.palmeida.pacientservice.controller;

import com.palmeida.pacientservice.entity.Pacient;
import com.palmeida.pacientservice.service.PacientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pacients")
@RequiredArgsConstructor
public class PacientController {

    private final PacientService pacientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void savePacient(@RequestBody Pacient pacient) {
        pacientService.savePaciente(pacient);
    }

    @GetMapping
    public ResponseEntity<List<Pacient>> findAllPacients() {
        return ResponseEntity.ok(pacientService.findAllPacients());
    }

    @GetMapping("/doctors/{doctorId}")
    public ResponseEntity<List<Pacient>> findAllPacients(@PathVariable("doctorId") Long doctorId) {
        return ResponseEntity.ok(pacientService.findAllPacientsByDoctorId(doctorId));
    }

}
