package com.arquitecturas.tp3.service;


import com.arquitecturas.tp3.dto.EstudianteDTO;
import com.arquitecturas.tp3.dto.MatriculaDTO;
import com.arquitecturas.tp3.dto.MatriculaRequest;
import com.arquitecturas.tp3.entities.Carrera;
import com.arquitecturas.tp3.entities.Estudiante;
import com.arquitecturas.tp3.entities.Matricula;
import com.arquitecturas.tp3.repository.CarreraRepository;
import com.arquitecturas.tp3.repository.EstudianteRepository;
import com.arquitecturas.tp3.repository.MatriculaRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class MatriculaService {

    @Autowired MatriculaRepository matriculaRepository;
    @Autowired EstudianteRepository estudianteRepository;
    @Autowired CarreraRepository carreraRepository;

    public Matricula addMatricula(MatriculaRequest req) {
        Matricula m = new Matricula();
        m.setId(req.getId());
        m.setAntiguedad(req.getAntiguedad());
        m.setGraduacion(req.getGraduacion());
        m.setInscripcion(req.getInscripcion());

        Estudiante estudiante = estudianteRepository.findById(req.getEstudianteId())
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));

        Carrera carrera = carreraRepository.findById(req.getCarreraId())
                .orElseThrow(() -> new RuntimeException("Carrera no encontrada"));

        m.setEstudiante(estudiante);
        m.setCarrera(carrera);

        return matriculaRepository.save(m);
    }
}
