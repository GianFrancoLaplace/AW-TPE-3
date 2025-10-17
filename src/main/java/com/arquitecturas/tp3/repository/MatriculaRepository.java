package com.arquitecturas.tp3.repository;

import com.arquitecturas.tp3.dto.*;

public interface MatriculaRepository {
    void insertarDesdeCSV(String rutaArchivo);
    //b) matricular un estudiante en una carrera
    void addMatricula(EstudianteDTO estudiante, CarreraDTO carrera,int inscripcion,int graduacion, int antiguedad);
}
