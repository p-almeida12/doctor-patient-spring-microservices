package com.palmeida.doctorservice.service;

import com.palmeida.doctorservice.client.PacientClient;
import com.palmeida.doctorservice.entity.Doctor;
import com.palmeida.doctorservice.entity.FullDoctorResponse;
import com.palmeida.doctorservice.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private PacientClient pacientClient;

    public void saveDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    public List<Doctor> findAllDoctors() {
        return doctorRepository.findAll();
    }

    public FullDoctorResponse findDoctorsWithPacients(Long doctorId) {
        System.err.println("doctorId: " + doctorId);
        System.err.println("${application.config.pacients-url}");
        var doctor = doctorRepository.findById(doctorId)
                .orElse(
                        Doctor.builder()
                                .firstName("NOT_FOUND")
                                .lastName("NOT_FOUND")
                                .email("NOT_FOUND")
                                .build()); //prevent null pointer exception

        //find all the pacients from the pacients microservice
        var pacients = pacientClient.findAllPacientsByDoctorId(doctorId);
        return FullDoctorResponse.builder()
                .firstName(doctor.getFirstName())
                .lastName(doctor.getLastName())
                .pacients(pacients)
                .build();
    }
}
