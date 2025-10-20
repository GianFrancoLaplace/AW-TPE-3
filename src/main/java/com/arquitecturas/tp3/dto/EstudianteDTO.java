package com.arquitecturas.tp3.dto;

import com.arquitecturas.tp3.entities.Estudiante;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EstudianteDTO {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private String ciudad;
    private int documento;
    private int LU;
}
