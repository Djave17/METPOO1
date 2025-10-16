package com.uam.cised.cisedapplication.domain.services;

import com.uam.cised.cisedapplication.domain.model.CursoDocente;
import com.uam.cised.cisedapplication.domain.model.Evaluacion;
import com.uam.cised.cisedapplication.domain.model.Formulario;
import com.uam.cised.cisedapplication.domain.repository.CursoDocenteRepository;
import com.uam.cised.cisedapplication.domain.repository.EvaluacionRepository;
import com.uam.cised.cisedapplication.domain.repository.FormularioRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EvaluacionService {

    private final EvaluacionRepository evaluacionRepo;
    private final CursoDocenteRepository cursoDocenteRepo;
    private final FormularioRepository formularioRepo;

    @Transactional
    public Evaluacion abrir(Long cursoDocenteId, Long formularioId, @Valid Evaluacion in) {
        CursoDocente cd = cursoDocenteRepo.findById(cursoDocenteId)
                .orElseThrow(() -> new EntityNotFoundException("CursoDocente no existe"));
        Formulario f = formularioRepo.findById(formularioId)
                .orElseThrow(() -> new EntityNotFoundException("Formulario no existe"));

        in.setCursoDocente(cd); // Asignar la relación
        in.setFormulario(f); // Asignar la relación
        if (in.getFechaRespuesta() == null) {
            in.setFechaRespuesta(OffsetDateTime.now());
        }
        return evaluacionRepo.save(in);
    }

    @Transactional(readOnly = true)
    public Evaluacion get(Long id) {
        return evaluacionRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Evaluación no existe"));
    }

    @Transactional(readOnly = true)
    public List<Evaluacion> listarPorCursoDocente(Long cursoDocenteId) {
        return evaluacionRepo.findByCursoDocenteId(cursoDocenteId);
    }

    @Transactional(readOnly = true)
    public List<Evaluacion> listarPorFormulario(Long formularioId) {
        return evaluacionRepo.findByFormularioId(formularioId);
    }

    @Transactional
    public Evaluacion actualizar(Long id, @Valid Evaluacion cambios) {
        Evaluacion ev = get(id);
        // Si permites cambiar formulario o cursoDocente, agregar validaciones aquí
        if (cambios.getFechaRespuesta() != null) {
            ev.setFechaRespuesta(cambios.getFechaRespuesta());
        }
        return ev;
    }

    @Transactional
    public void eliminar(Long id) {
        evaluacionRepo.delete(get(id));
    }
}
