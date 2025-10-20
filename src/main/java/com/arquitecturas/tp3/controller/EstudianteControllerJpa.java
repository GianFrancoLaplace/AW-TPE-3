package com.arquitecturas.tp3.controller;

import com.arquitecturas.tp3.entities.Estudiante;
import com.arquitecturas.tp3.dto.EstudianteDTO;
import com.arquitecturas.tp3.repository.EstudianteRepository;
import com.arquitecturas.tp3.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")

public class EstudianteControllerJpa {
    @Autowired
    private final EstudianteService estudianteService;

    public EstudianteControllerJpa(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping("")
    public ResponseEntity<List<Estudiante>> estudiantes() {
        List<Estudiante> estudiantes = estudianteService.buscarEstudiantes();
        if(estudiantes.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(estudiantes);
    }

    @GetMapping("/edad/{edad}")
    public ResponseEntity<List<Estudiante>> estudiantes(@PathVariable int edad) {
        List<Estudiante> estudiantes = estudianteService.buscarEstudiantesPorEdad(edad);
        if(estudiantes.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(estudiantes);
    }

    @GetMapping("/genero/{genero}")
    public ResponseEntity<List<Estudiante>> estudianteXGenero(@PathVariable String genero) {
        List<Estudiante> estudiantes = estudianteService.buscarEstudiantePorGenero(genero);
        if(estudiantes.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(estudiantes);
    }

    @GetMapping("/carrera/{carrera}/ciudad/{ciudad}")
    public ResponseEntity<List<Estudiante>> buscarEstudiantesPorCarreraYCiudad(@PathVariable String carrera,@PathVariable String ciudad) {
        List<Estudiante> estudiantes = estudianteService.buscarEstudiantesPorCarreraYCiudad(carrera, ciudad);
        if(estudiantes.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(estudiantes);
    }

    @GetMapping("/nroLibreta/{nroLibreta}")
    public ResponseEntity<Estudiante> buscarEstudiantesPorNroLibreta(@PathVariable int nroLibreta) {
        Estudiante estudiantes = estudianteService.buscarEstudiantePorNroLibreta(nroLibreta);
        if(estudiantes == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(estudiantes);
    }

    @GetMapping("/ordenadosEdad")
    public ResponseEntity<List<Estudiante>> buscarEstudiantesOrdenadosPorEdad() {
        List<Estudiante> estudiantes = estudianteService.buscarEstudiantesOrdenadosPorEdad();
        if(estudiantes.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(estudiantes);
    }
}
