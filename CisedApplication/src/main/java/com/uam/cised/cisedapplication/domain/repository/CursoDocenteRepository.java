package com.uam.cised.cisedapplication.domain.repository;


import com.uam.cised.cisedapplication.domain.model.CursoDocente;
import com.uam.cised.cisedapplication.domain.model.Docente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CursoDocenteRepository extends JpaRepository<CursoDocente, Long> {
    // Clave compuesta lógica (única)
    Optional<CursoDocente> findByAsignaturaIdAndDocenteId(Long asignaturaId, Long docenteId);
    boolean existsByAsignaturaIdAndDocenteId(Long asignaturaId, Long docenteId);

    // Navegación por lados
    List<CursoDocente> findByAsignaturaId(Long asignaturaId);
    List<CursoDocente> findByDocenteId(Long docenteId);

}
