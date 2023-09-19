package com.palmeida.doctorservice.repository;

import com.palmeida.doctorservice.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
