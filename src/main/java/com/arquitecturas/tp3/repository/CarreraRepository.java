package com.arquitecturas.tp3.repository;

import com.arquitecturas.tp3.dto.ReporteCarreraDTO;
import com.arquitecturas.tp3.dto.ReporteCarrerasXInscriptosDTO;
import com.arquitecturas.tp3.entities.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Long> {

    // f) Recuperar las carreras con estudiantes inscriptos, ordenar por cantidad de inscriptos
    @Query("SELECT new com.arquitecturas.tp3.dto.ReporteCarrerasXInscriptosDTO(" +
            "c.nombre, " +
            "COUNT(DISTINCT m.estudiante.id)) " +
            "FROM Carrera c " +
            "JOIN c.matriculas m " +
            "GROUP BY c.nombre " +
            "ORDER BY COUNT(DISTINCT m.estudiante.id) DESC")
    List<ReporteCarrerasXInscriptosDTO> getCarrerasActivas();

    // h) Generar reporte de carreras con inscriptos y egresados por año
    @Query("SELECT new com.arquitecturas.tp3.dto.ReporteCarreraDTO(" +
            "c.nombre, " +
            "COUNT(m.estudiante.id), " +
            "COUNT(CASE WHEN m.graduacion > 0 THEN m.estudiante.id END), " +
            "m.inscripcion) " +
            "FROM Carrera c " +
            "JOIN c.matriculas m " +
            "GROUP BY c.nombre, m.inscripcion " +
            "ORDER BY c.nombre ASC, m.inscripcion ASC")
    List<ReporteCarreraDTO> generarReporteCarrerasPorAnio();
}