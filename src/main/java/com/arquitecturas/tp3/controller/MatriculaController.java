package com.arquitecturas.tp3.controller;


import com.arquitecturas.tp3.dto.MatriculaDTO;
import com.arquitecturas.tp3.dto.MatriculaRequest;
import com.arquitecturas.tp3.entities.Matricula;
import com.arquitecturas.tp3.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {
    @Autowired
    private MatriculaService matriculaService;

    public MatriculaController(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    // b)
    @PostMapping
    public ResponseEntity<Matricula> matricular(@RequestBody MatriculaRequest req) {
        Matricula m = matriculaService.addMatricula(req);
        return ResponseEntity.ok(m);
    }
}