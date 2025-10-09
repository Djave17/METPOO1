package repository;

import entities.Carrera;

import java.util.List;

public interface ICarrera {
    Carrera guardarCarrera(Carrera carrera);
    List<Carrera> listarCarreras();
    void actualizarCarrera(Long idCarrera);
    void eliminarCarrera(Long id);
    Carrera buscarCarreraPorId(Long id);

}

