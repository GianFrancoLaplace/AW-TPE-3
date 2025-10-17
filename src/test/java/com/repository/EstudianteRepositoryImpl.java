package com.arquitecturas.tp1.repository;

import com.opencsv.CSVReader;
import com.arquitecturas.tp1.dto.EstudianteDTO;
import com.arquitecturas.tp1.entities.Estudiante;
import factory.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class EstudianteRepositoryImpl implements EstudianteRepository {
    private EntityManager em;

    public EstudianteRepositoryImpl() {
        this.em = JPAUtil.getEntityManager();
    }

    @Override
    public void insertarDesdeCSV(String rutaArchivo) {
        EntityManager em = JPAUtil.getEntityManager();

        try (CSVReader reader = new CSVReader(new FileReader(rutaArchivo))) {
            String[] linea;
            reader.readNext(); // salta cabecera

            em.getTransaction().begin();

            while ((linea = reader.readNext()) != null) {
                Estudiante estudiante = new Estudiante();
                estudiante.setId(Integer.parseInt(linea[0]));
                estudiante.setNombre(linea[1]);
                estudiante.setApellido(linea[2]);
                estudiante.setEdad(Integer.parseInt(linea[3]));
                estudiante.setGenero(linea[4]);
                estudiante.setCiudad(linea[5]);
                estudiante.setLU(Integer.parseInt(linea[6]));

                em.merge(estudiante);
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    //a) dar de alta un estudiante
    @Override
    public void addEstudiante(int id, String nombre, String apellido, int edad, String genero, String ciudad, int LU) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();

            Estudiante estudiante = new Estudiante();
            estudiante.setId(id); //DNI
            estudiante.setNombre(nombre);
            estudiante.setApellido(apellido);
            estudiante.setEdad(edad);
            estudiante.setGenero(genero);
            estudiante.setCiudad(ciudad);
            estudiante.setLU(LU);

            em.persist(estudiante);

            em.getTransaction().commit();
            System.out.println("estudiante insertado: " + id);
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    //c) recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple
    @Override
    public List<EstudianteDTO> buscarEstudiantesOrdenadosPor(String atributo) {
        String jpql = "SELECT e FROM Estudiante e ORDER BY e." + atributo + " DESC";
        List<Estudiante> estudiantes = em.createQuery(jpql, Estudiante.class)
                .getResultList();

        return estudiantes.stream()
                .map(EstudianteDTO::new)
                .collect(Collectors.toList());
    }

    //d) recuperar un estudiante, en base a su número de libreta universitaria.
    @Override
    public EstudianteDTO buscarEstudiantePorLU(int LU) {
        String jpql = "SELECT e FROM Estudiante e WHERE e.LU = :LU";

        try {
            Estudiante estudiante = em.createQuery(jpql, Estudiante.class)
                    .setParameter("LU", LU)
                    .getSingleResult();

            return new EstudianteDTO(estudiante);

        } catch (Error e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    //e) recuperar todos los estudiantes, en base a su género.
    @Override
    public List<EstudianteDTO> buscarEstudiantesPorGenero(String genero) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        try{
            String queryStr = "FROM Estudiante e WHERE e.genero = :genero";

            Query query = em.createQuery(queryStr, Estudiante.class);
            query.setParameter("genero", genero); // 'genero' is the String value, e.g., "male"
            List<EstudianteDTO> estudianteDTOS = query.getResultList();

            for (Object e: estudianteDTOS){
//                EstudianteDTO estudianteDTO  = (EstudianteDTO) e;
//                System.out.println(estudianteDTO.getApellido()+estudianteDTO.getGenero());
                System.out.println(e.toString());
                System.out.println();
            }

            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return List.of();
    }

    //g) recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia
    public List<EstudianteDTO> buscarEstudiantesPorCarreraYCiudad(String carrera, String ciudad) {
        System.out.println("Carrera y Ciudad: " + carrera + ", " + ciudad);
        try {
            return (List<EstudianteDTO>) em.createQuery(
                    "SELECT new dto.EstudianteDTO(e.id, e.nombre, e.apellido, e.edad, e.genero, e.ciudad, e.documento, e.LU)" +
                            "FROM Matricula m JOIN Estudiante e " +
                            "ON m.estudiante.id = e.id " +
                            "WHERE e.ciudad = :ciudad AND m.carrera.nombre = :carrera",
                    EstudianteDTO.class
            ).setParameter("carrera", carrera).setParameter("ciudad", ciudad).getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
