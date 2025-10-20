package com.arquitecturas.tp3.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "estudiante")
@Data
public class Estudiante {

    @Id
    private Long id;

    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private String ciudad;
    private int documento;
    //AK
    @Column(name = "LU")
    private int LU;

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Matricula> matriculas = new ArrayList<>();
}

