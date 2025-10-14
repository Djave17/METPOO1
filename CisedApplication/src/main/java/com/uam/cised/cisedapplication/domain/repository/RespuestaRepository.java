package com.uam.cised.cisedapplication.domain.repository;

import com.uam.cised.cisedapplication.domain.model.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {
    List<Respuesta> findByEvaluacionId(Long evaluacionId);
    List<Respuesta> findByPreguntaId(Long preguntaId);

    // Útil para métricas rápidas por curso/docente
    long countByEvaluacionId(Long evaluacionId);
}
