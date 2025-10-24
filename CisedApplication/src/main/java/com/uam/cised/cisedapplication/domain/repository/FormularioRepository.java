package com.uam.cised.cisedapplication.domain.repository;

import com.uam.cised.cisedapplication.domain.model.Formulario;
import com.uam.cised.cisedapplication.domain.model.TipoFormulario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Acceso a datos de Formulario.
 * Extiende JpaRepository para CRUD:
 *   - save(entity)  -> crear/actualizar
 *   - findById(id)  -> leer uno
 *   - findAll()    -> leer todos
 *   - deleteById()  -> eliminar
 */

public interface FormularioRepository extends JpaRepository<Formulario, Long> {

    Optional<Formulario> findByTipo(TipoFormulario tipo);

    boolean existsByTipo(TipoFormulario tipo);
}

