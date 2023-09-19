package com.palmeida.pacientservice.repository;

import com.palmeida.pacientservice.entity.Pacient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PacientRepository extends JpaRepository<Pacient, Long> {

    List<Pacient> findAllByDoctorId(Long doctorId);

}
