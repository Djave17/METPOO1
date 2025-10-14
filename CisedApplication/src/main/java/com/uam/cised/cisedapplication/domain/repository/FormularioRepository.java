package com.uam.cised.cisedapplication.domain.repository;

import com.uam.cised.cisedapplication.domain.model.Formulario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FormularioRepository extends JpaRepository<Formulario, Long> {
    Optional<Formulario> findByTipoIgnoreCase(String tipo);
    boolean existsByTipoIgnoreCase(String tipo);
}
