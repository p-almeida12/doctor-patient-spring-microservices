package com.palmeida.pacientservice.service;

import com.palmeida.pacientservice.entity.Pacient;
import com.palmeida.pacientservice.repository.PacientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacientService {

    private final PacientRepository pacientRepository;

    public void savePaciente(Pacient pacient) {
        pacientRepository.save(pacient);
    }

    public List<Pacient> findAllPacients() {
        return pacientRepository.findAll();
    }

    public List<Pacient> findAllPacientsByDoctorId(Long doctorId) {
        return pacientRepository.findAllByDoctorId(doctorId);
    }
}
