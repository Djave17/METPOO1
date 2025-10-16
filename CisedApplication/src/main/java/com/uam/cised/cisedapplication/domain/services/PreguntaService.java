package com.uam.cised.cisedapplication.domain.services;

import com.uam.cised.cisedapplication.domain.model.Formulario;
import com.uam.cised.cisedapplication.domain.model.Pregunta;
import com.uam.cised.cisedapplication.domain.repository.FormularioRepository;
import com.uam.cised.cisedapplication.domain.repository.PreguntaRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PreguntaService {

    private final PreguntaRepository preguntaRepo;
    private final FormularioRepository formularioRepo;

    @Transactional
    public Pregunta crear(Long formularioId, @Valid Pregunta in) {
        // Verificar que exista el formulario
        Formulario f = formularioRepo.findById(formularioId)
                .orElseThrow(() -> new EntityNotFoundException("Formulario no existe"));

        in.setFormulario(f);
        return preguntaRepo.save(in);
    }

    @Transactional(readOnly = true)
    public Pregunta get(Long id) {
        return preguntaRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pregunta no existe"));
    }

    @Transactional(readOnly = true)
    public List<Pregunta> listarPorFormulario(Long formularioId) {
        return preguntaRepo.findByFormularioId(formularioId);
    }

    @Transactional
    public Pregunta actualizar(Long id, @Valid Pregunta cambios) {
        Pregunta p = get(id);
        if (cambios.getTexto() != null) p.setTexto(cambios.getTexto());
        if (cambios.getTipo() != null)  p.setTipo(cambios.getTipo());
        if (cambios.getEsObligatoria() != null) p.setEsObligatoria(cambios.getEsObligatoria());

        return p;
    }

    @Transactional
    public void eliminar(Long id) {
        if(id != null && !preguntaRepo.existsById(id)){
            throw new EntityNotFoundException("La pregunta no existe");
        }
        preguntaRepo.delete(get(id));
    }
}
