package com.arquitecturas.tp3.service;

import com.arquitecturas.tp3.repository.CarreraRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class CarreraService {
    private CarreraRepository carreraRepository;
}
