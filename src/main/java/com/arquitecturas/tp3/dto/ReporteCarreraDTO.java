package com.arquitecturas.tp3.dto;

import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
public class ReporteCarreraDTO {
    private String nombreCarrera;
    private long inscriptos;
    private long egresados;
    private int inscripcion;

    public ReporteCarreraDTO(String nombreCarrera, Long inscriptos, Long egresados, int inscripcion) {
        this.nombreCarrera = nombreCarrera;
        this.inscriptos = (inscriptos != null) ? inscriptos : 0L;
        this.egresados = (egresados != null) ? egresados : 0L;
        this.inscripcion = inscripcion;
    }

    @Override
    public String toString() {
        return "Carrera: " + nombreCarrera +
                ", Año: " + inscripcion +
                ", Inscriptos: " + inscriptos +
                ", Egresados: " + egresados;
    }
}