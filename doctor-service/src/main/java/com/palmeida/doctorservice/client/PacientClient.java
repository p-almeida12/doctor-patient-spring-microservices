package com.palmeida.doctorservice.client;

import com.palmeida.doctorservice.entity.Pacient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface PacientClient {

    @GetExchange("doctors/{doctorId}")
    List<Pacient> findAllPacientsByDoctorId(@PathVariable("doctorId") Long doctorId);
}
