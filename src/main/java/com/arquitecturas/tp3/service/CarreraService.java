package com.arquitecturas.tp3.service;

import com.arquitecturas.tp3.dto.ReporteCarreraDTO;
import com.arquitecturas.tp3.dto.ReporteCarrerasXInscriptosDTO;
import com.arquitecturas.tp3.repository.CarreraRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class CarreraService {
    @Autowired
    private CarreraRepository carreraRepository;

    // Consigna f)
    public List<ReporteCarrerasXInscriptosDTO> getCarrerasActivas() {
        return carreraRepository.getCarrerasActivas();
    }

    // Consigna h)
    public List<ReporteCarreraDTO> generarReporteCarrerasPorAnio() {
        return carreraRepository.generarReporteCarrerasPorAnio();
    }
}
