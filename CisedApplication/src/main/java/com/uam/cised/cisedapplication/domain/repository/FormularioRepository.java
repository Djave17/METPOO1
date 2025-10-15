package com.uam.cised.cisedapplication.domain.repository;

import com.uam.cised.cisedapplication.domain.model.Formulario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FormularioRepository extends JpaRepository<Formulario, Long> {
    Optional<Formulario> findByTipo_NombreIgnoreCase(String nombre);
    boolean existsByTipo_NombreIgnoreCase(String nombre);
}
