package com.uam.cised.cisedapplication.domain.repository;

import com.uam.cised.cisedapplication.domain.model.Evaluacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.OffsetDateTime;
import java.util.List;

public interface EvaluacionRepository extends JpaRepository<Evaluacion, Long> {
    List<Evaluacion> findByCursoDocenteId(Long cursoDocenteId);
    List<Evaluacion> findByFormularioId(Long formularioId);
    List<Evaluacion> findByFechaRespuestaBetween(OffsetDateTime start, OffsetDateTime end);
}
