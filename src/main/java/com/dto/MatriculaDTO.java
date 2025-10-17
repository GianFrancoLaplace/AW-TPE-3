package com.dto;

import com.entities.Carrera;
import com.entities.Estudiante;
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
