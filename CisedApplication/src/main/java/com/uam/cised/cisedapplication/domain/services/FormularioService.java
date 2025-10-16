package com.uam.cised.cisedapplication.domain.services;


import com.uam.cised.cisedapplication.domain.model.Formulario;
import com.uam.cised.cisedapplication.domain.repository.FormularioRepository;
import com.uam.cised.cisedapplication.domain.repository.PreguntaRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.jvnet.hk2.annotations.Service;

@Service
@RequiredArgsConstructor
public class FormularioService {
    private final FormularioRepository formularioRepository;
    private final PreguntaRepository preguntaRepository;

    @Transactional
    public Formulario crearFormulario(Formulario in) {
        return null;
    }
    // get/actualizar/eliminar análogos



}

