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
    //buscar estudiantes por edad
    @Query("SELECT e FROM Estudiante e WHERE e.edad = :edad")
    List<EstudianteDTO> findByEdad(@Param("edad") int edad);

    //buscar estudiante por genero
    @Query("SELECT e FROM Estudiante e WHERE e.genero = :genero")
    List<EstudianteDTO> buscarEstudiantesPorGenero(@Param("genero") String genero);

    @Query("SELECT m FROM Matricula m JOIN Estudiante e ON m.estudiante.id = e.id WHERE e.ciudad = :ciudad AND m.carrera.nombre = :carrera")
    List<EstudianteDTO> buscarEstudiantesPorCarreraYCiudad (@Param("carrera") String carrera, @Param("ciudad") String ciudad);

    @Query("SELECT e FROM Estudiante e ORDER BY e.edad")
    List<EstudianteDTO> buscarEstudiantesOrderPorEdad();

    //    void insertarDesdeCSV(String rutaArchivo);
//    //a) dar de alta un estudiante
//    void addEstudiante(int id,String nombre, String apellido, int edad, String genero, String ciudad, int LU);
//    //c) recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple
//    List<EstudianteDTO> buscarEstudiantesOrdenadosPor(String atributo);
//    //d) recuperar un estudiante, en base a su número de libreta universitaria.
//    EstudianteDTO buscarEstudiantePorLU(int LU);
//    //e) recuperar todos los estudiantes, en base a su género.
//    List<EstudianteDTO> buscarEstudiantesPorGenero(String genero);
//    //g) recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia
//    List<EstudianteDTO> buscarEstudiantesPorCarreraYCiudad(String carrera, String ciudad);
}
