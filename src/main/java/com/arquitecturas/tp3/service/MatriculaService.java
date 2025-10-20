package com.arquitecturas.tp3.service;

import com.arquitecturas.tp3.repository.MatriculaRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class MatriculaService {
    private MatriculaRepository matriculaRepository;
}
