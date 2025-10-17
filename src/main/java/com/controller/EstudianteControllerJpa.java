package com.controller;

import com.arquitecturas.tp1.Test;
import com.entities.Estudiante;
import com.arquitecturas.tp1.dto.EstudianteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")

public class EstudianteControllerJpa {
    @Autowired
    private final Test test;

    public EstudianteControllerJpa(Test test) {
        this.test = test;
    }

    @GetMapping("")
    public Iterable<Estudiante> estudiantes() {
        return test.findAll();
    }

    @GetMapping("edad/{edad}")
    public Iterable<Estudiante> estudiantes(@PathVariable int edad) {
        return test.findByEdad(edad);
    }

    @GetMapping("genero/{genero}")
    public List<EstudianteDTO> estudianteXGenero(@PathVariable String genero) {
        return test.buscarEstudiantesPorGenero(genero);

    }
}
