package com.arquitecturas.tp3.controller;

import com.arquitecturas.tp3.entities.Matricula;
import com.arquitecturas.tp3.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {
    @Autowired
    private final MatriculaRepository repository;

    public MatriculaController(MatriculaRepository repository) {
        this.repository = repository;
    }

    // b)
    @PostMapping("")
    public Matricula matricular(@RequestBody Matricula matricula) {
        return repository.save(matricula);
    }
}