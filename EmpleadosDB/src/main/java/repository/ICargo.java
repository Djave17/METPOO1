package repository;

import entities.Cargo;

import java.util.List;
public interface ICargo {

    Cargo guardarCargo(Cargo cargo);
    List<Cargo> listarCargos();
    void actualizarCargo(Cargo cargo);
    void eliminarCargo(Long id);
    Cargo buscarCargoPorId(Long id);
}
