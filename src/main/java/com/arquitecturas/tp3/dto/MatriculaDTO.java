package com.arquitecturas.tp3.dto;

import com.arquitecturas.tp3.entities.Carrera;
import com.arquitecturas.tp3.entities.Estudiante;
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
