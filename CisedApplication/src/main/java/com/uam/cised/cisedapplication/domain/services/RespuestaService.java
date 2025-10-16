package com.uam.cised.cisedapplication.domain.services;

import com.uam.cised.cisedapplication.domain.model.Evaluacion;
import com.uam.cised.cisedapplication.domain.model.Pregunta;
import com.uam.cised.cisedapplication.domain.model.Respuesta;
import com.uam.cised.cisedapplication.domain.repository.EvaluacionRepository;
import com.uam.cised.cisedapplication.domain.repository.PreguntaRepository;
import com.uam.cised.cisedapplication.domain.repository.RespuestaRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RespuestaService {

    private final RespuestaRepository respuestaRepo;
    private final EvaluacionRepository evaluacionRepo;
    private final PreguntaRepository preguntaRepo;

    @Transactional
    public Respuesta responder(Long evaluacionId, Long preguntaId, @Valid Respuesta in) {
        Evaluacion ev = evaluacionRepo.findById(evaluacionId)
                .orElseThrow(() -> new EntityNotFoundException("Evaluación no existe"));
        Pregunta pr = preguntaRepo.findById(preguntaId)
                .orElseThrow(() -> new EntityNotFoundException("Pregunta no existe"));

        // (Opcional) validar tipo de respuesta según pr.getTipo()

        in.setEvaluacion(ev);
        in.setPregunta(pr);
        return respuestaRepo.save(in);
    }

    @Transactional(readOnly = true)
    public List<Respuesta> listarPorEvaluacion(Long evaluacionId) {
        return respuestaRepo.findByEvaluacionId(evaluacionId);
    }

    @Transactional(readOnly = true)
    public List<Respuesta> listarPorPregunta(Long preguntaId) {
        return respuestaRepo.findByPreguntaId(preguntaId);
    }

    @Transactional
    public void eliminar(Long id) {
        respuestaRepo.delete(
                respuestaRepo.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Respuesta no existe"))
        );
    }
}
