package com.arquitecturas.tp3.repository;

import com.arquitecturas.tp3.entities.Estudiante;
import com.arquitecturas.tp3.dto.EstudianteDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EstudianteRepositoryImpl extends JpaRepository<Estudiante, Long> {

    //buscar estudiantes por edad
    @Query("""
    SELECT new com.arquitecturas.tp3.dto.EstudianteDTO(
        e.id,
        e.nombre,
        e.apellido,
        e.edad,
        e.genero,
        e.ciudad,
        e.documento,
        e.nroLibreta
    )
    FROM Estudiante e
    WHERE e.edad = :edad
""")
    List<EstudianteDTO> findByEdad(@Param("edad") int edad);

    //buscar estudiante por genero
    @Query("""
    SELECT new com.arquitecturas.tp3.dto.EstudianteDTO(
        e.id,
        e.nombre,
        e.apellido,
        e.edad,
        e.genero,
        e.ciudad,
        e.documento,
        e.nroLibreta
    )
    FROM Estudiante e
    WHERE e.genero = :genero
""")
    List<EstudianteDTO> buscarEstudiantesPorGenero(@Param("genero") String genero);

    @Query("""
    SELECT new com.arquitecturas.tp3.dto.EstudianteDTO(
        e.id,
        e.nombre,
        e.apellido,
        e.edad,
        e.genero,
        e.ciudad,
        e.documento,
        e.nroLibreta
    )
    FROM Matricula m JOIN Estudiante e ON m.estudiante.id = e.id\s
    WHERE e.ciudad = :ciudad AND m.carrera.nombre = :carrera
""")

    List<EstudianteDTO> buscarEstudiantesPorCarreraYCiudad (@Param("carrera") String carrera, @Param("ciudad") String ciudad);










}
