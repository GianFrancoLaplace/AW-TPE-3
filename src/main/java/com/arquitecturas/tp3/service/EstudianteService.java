package com.arquitecturas.tp3.service;

import com.arquitecturas.tp3.dto.EstudianteDTO;
import com.arquitecturas.tp3.entities.Estudiante;
import com.arquitecturas.tp3.repository.EstudianteRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class EstudianteService {
    private EstudianteRepository estudianteRepository;

    public void addEstudiante(Estudiante estudiante) {
        estudianteRepository.save(estudiante);
    }

    public List<EstudianteDTO> buscarEstudiantesPorEdad(int edad) {
        return estudianteRepository.findByEdad(edad);
    }

    public List<EstudianteDTO> buscarEstudiantePorGenero(String genero) {
        return estudianteRepository.buscarEstudiantesPorGenero(genero);
    }

    public List<EstudianteDTO> buscarEstudiantesPorCarreraYCiudad(String carrera, String ciudad) {
        return estudianteRepository.buscarEstudiantesPorCarreraYCiudad(carrera, ciudad);
    }

    public List<EstudianteDTO> buscarEstudiantesOrdenadosPorEdad() {
        return estudianteRepository.buscarEstudiantesOrderPorEdad();
    }
}
