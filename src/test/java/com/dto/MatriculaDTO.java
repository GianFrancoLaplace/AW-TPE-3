package com.arquitecturas.tp1.dto;

import com.arquitecturas.tp1.entities.Carrera;
import com.arquitecturas.tp1.entities.Estudiante;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MatriculaDTO {
    private int id;
    private Estudiante estudiante;
    private Carrera carrera;
    private int inscripcion;
    private int graduacion;
    private int antiguedad;
}
