package com.arquitecturas.tp3.controller;

import com.arquitecturas.tp3.dto.ReporteCarreraDTO;
import com.arquitecturas.tp3.dto.ReporteCarrerasXInscriptosDTO;
import com.arquitecturas.tp3.repository.CarreraRepository;
import com.arquitecturas.tp3.service.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/carreras")
public class CarreraControllerJpa {
    @Autowired
    private CarreraService carreraService;

    @GetMapping("/activas")
    public ResponseEntity<List<ReporteCarrerasXInscriptosDTO>> getCarrerasActivas() {
        List<ReporteCarrerasXInscriptosDTO> carreras = carreraService.getCarrerasActivas();
        if(carreras.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(carreras);
    }

    // h) Reporte de carreras con inscriptos y egresados por año
    @GetMapping("/reporte")
    public ResponseEntity<List<ReporteCarreraDTO>> obtenerReporteCarreras() {
        List<ReporteCarreraDTO> reporte = carreraService.generarReporteCarrerasPorAnio();
        if(reporte.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(reporte);
    }
}
