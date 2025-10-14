package com.uam.cised.cisedapplication.domain.repository;

import com.uam.cised.cisedapplication.domain.model.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.List;

public interface AsignaturaRepository {

    // Unicidades por programa
    Optional<Asignatura> findByCodigoIgnoreCaseAndProgramaId(String codigo, Long programaId);
    Optional<Asignatura> findByNombreIgnoreCaseAndProgramaId(String nombre, Long programaId);

    boolean existsByCodigoIgnoreCaseAndProgramaId(String codigo, Long programaId);
    boolean existsByNombreIgnoreCaseAndProgramaId(String nombre, Long programaId);

    // Filtros
    Page<Asignatura> findByNombreContainingIgnoreCase(String q, Pageable pageable);
    List<Asignatura> findByEstado(boolean estado);
}
