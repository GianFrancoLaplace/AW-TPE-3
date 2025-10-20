package com.arquitecturas.tp3.repository;

import com.arquitecturas.tp3.dto.EstudianteDTO;
import com.arquitecturas.tp3.entities.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    @Query("SELECT e FROM Estudiante e WHERE e.edad = :edad")
    List<Estudiante> findByEdad(@Param("edad") int edad);

    @Query("SELECT e FROM Estudiante e WHERE e.genero = :genero")
    List<Estudiante> buscarEstudiantesPorGenero(@Param("genero") String genero);

    @Query("SELECT e " +
            "FROM Estudiante e, IN (e.matriculas) m " +
            "WHERE m.carrera.nombre = :carrera AND e.ciudad = :ciudad")
    List<Estudiante> buscarEstudiantesPorCarreraYCiudad (@Param("carrera") String carrera, @Param("ciudad") String ciudad);

    @Query("SELECT e FROM Estudiante e ORDER BY e.edad")
    List<Estudiante> buscarEstudiantesOrderPorEdad();

    @Query("SELECT e FROM Estudiante e WHERE e.LU = :nroLibreta")
    Estudiante buscarEstudianteSegunNumeroLibreta(@Param("nroLibreta") int nroLibreta);
}
