package com.uam.cised.cisedapplication.domain.repository;

import com.uam.cised.cisedapplication.domain.model.Docente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DocenteRepository extends JpaRepository<Docente, Long> {
    Optional<Docente> findByEmailIgnoreCase(String email);
    boolean existsByEmailIgnoreCase(String email);

    // Estado (Activo/Inactivo)
    List<Docente> findByEstado(boolean estado);
}