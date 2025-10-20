package com.arquitecturas.tp3.repository;

import com.arquitecturas.tp3.entities.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
    // void insertarDesdeCSV(String rutaArchivo);

    //b) matricular un estudiante en una carrera
    // void addMatricula(EstudianteDTO estudiante, CarreraDTO carrera,int inscripcion,int graduacion, int antiguedad);
}
