package com.uam.cised.cisedapplication.domain.repository;

import com.uam.cised.cisedapplication.domain.model.Formulario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Acceso a datos de Formulario.
 * Extiende JpaRepository para CRUD:
 *   - save(entity)  -> crear/actualizar
 *   - findById(id)  -> leer uno
 *   - findAll()     -> leer todos
 *   - deleteById()  -> eliminar
 */

public interface FormularioRepository extends JpaRepository<Formulario, Long> {
    Optional<Formulario> findByTipo_NombreIgnoreCase(String nombre);
    boolean existsByTipoIgnoreCase(String nombre);
    boolean existsByTipo_NombreIgnoreCase(String nombre);


}
