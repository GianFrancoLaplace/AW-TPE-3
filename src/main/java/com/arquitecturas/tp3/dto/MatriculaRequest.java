package com.arquitecturas.tp3.dto;

import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MatriculaRequest {
    private Long id;
    private Long estudianteId;
    private Long carreraId;
    private int inscripcion;
    private int graduacion;
    private int antiguedad;
}