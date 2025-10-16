package com.uam.cised.cisedapplication.domain.services;

import com.uam.cised.cisedapplication.domain.model.Formulario;
import com.uam.cised.cisedapplication.domain.model.Pregunta;
import com.uam.cised.cisedapplication.domain.repository.FormularioRepository;
import com.uam.cised.cisedapplication.domain.repository.PreguntaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

public class PreguntaService {
    private final PreguntaRepository repo;
    private final FormularioRepository formRepo;

    @Transactional
    public Pregunta crear(Long formularioId, Pregunta in) {
        Formulario f = formRepo.findById(formularioId)
                .orElseThrow(() -> new EntityNotFoundException("Formulario no existe"));
        in.setFormulario(f);
        return repo.save(in);
    }
    // get/actualizar/eliminar, listar por formulario…
}