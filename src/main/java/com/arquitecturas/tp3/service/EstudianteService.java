package com.arquitecturas.tp3.service;

import com.arquitecturas.tp3.dto.EstudianteDTO;
import com.arquitecturas.tp3.entities.Estudiante;
import com.arquitecturas.tp3.repository.EstudianteRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class EstudianteService {
    private EstudianteRepository estudianteRepository;

    public void addEstudiante(Estudiante estudiante) {
        estudianteRepository.save(estudiante);
    }

    public List<Estudiante> buscarEstudiantesPorEdad(int edad) {
        return estudianteRepository.findByEdad(edad);
    }

    public List<Estudiante> buscarEstudiantePorGenero(String genero) {
        return estudianteRepository.buscarEstudiantesPorGenero(genero);
    }

    public List<Estudiante> buscarEstudiantesPorCarreraYCiudad(String carrera, String ciudad) {
        return estudianteRepository.buscarEstudiantesPorCarreraYCiudad(carrera, ciudad);
    }

    public List<Estudiante> buscarEstudiantesOrdenadosPorEdad() {
        return estudianteRepository.buscarEstudiantesOrderPorEdad();
    }

    public Estudiante buscarEstudiantePorNroLibreta(int nroLibreta) {
        return estudianteRepository.buscarEstudianteSegunNumeroLibreta(nroLibreta);
    }

    public List<Estudiante> buscarEstudiantes() {
        return estudianteRepository.findAll();
    }
}
