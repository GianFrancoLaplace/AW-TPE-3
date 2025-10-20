package com.arquitecturas.tp3.repository;

import com.arquitecturas.tp3.dto.ReporteCarrerasXInscriptosDTO;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface CarreraRepository {
    void insertarDesdeCSV(String rutaArchivo);
    //f) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
    List<ReporteCarrerasXInscriptosDTO> getCarrerasActivas();
}
