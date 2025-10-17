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

    @Query("SELECT e FROM Estudiante e WHERE e.edad = :edad")
    List<Estudiante> findByEdad(@Param("edad") int edad);

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







}
