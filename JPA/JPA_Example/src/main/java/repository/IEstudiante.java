package repository;

import entities.Carrera;
import entities.Estudiante;

import java.util.List;

public interface IEstudiante {

    public Estudiante guardarEstudiante(Estudiante estudiante);
    public List<Estudiante> listarEstudiantes();
    void actualizarEstudiante(Long idCarrera);
    void eliminarEstudiante(Long id);
}
