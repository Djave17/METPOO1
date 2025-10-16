package com.uam.cised.cisedapplication.domain.services;

import com.uam.cised.cisedapplication.domain.model.Formulario;
import com.uam.cised.cisedapplication.domain.model.Pregunta;
import com.uam.cised.cisedapplication.domain.repository.FormularioRepository;
import com.uam.cised.cisedapplication.domain.repository.PreguntaRepository;

import jakarta.persistence.EntityExistsException;        // Excepción estándar si hay duplicidad
import jakarta.persistence.EntityNotFoundException;     // Excepción estándar si no existe el recurso
import jakarta.validation.Valid;                        // @Valid para validar DTO/entidad de entrada (si la usas)
import lombok.RequiredArgsConstructor;                  // Genera constructor con final fields
import org.springframework.stereotype.Service;          // Marca clase como servicio de negocio
import org.springframework.transaction.annotation.Transactional; // Manejo de transacciones

import java.util.List;

@Service
@RequiredArgsConstructor
public class FormularioService {
    private final FormularioRepository formularioRepository;
    private final PreguntaRepository preguntaRepository;

    @Transactional
    public Formulario crearFormulario(Formulario in) {
        if (formularioRepository.existsByTipoIgnoreCase(in.getTipo())) {
            throw new EntityExistsException("Ya existe un formulario con el tipo: " + in.getTipo());
        }
        return formularioRepository.save(in); // INSERT
    }

    @Transactional(readOnly = true)      // Solo lectura: no abre transacción de escritura
    public Formulario get(Long id) {
        return formularioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Formulario no existe"));
    }

    @Transactional
    public Formulario actualizar(Long id, @Valid Formulario cambios) {
        Formulario f = get(id); // Entidad "managed"

        if (cambios.getTipo() != null &&
                !cambios.getTipo().equalsIgnoreCase(f.getTipo()) &&
                formularioRepository.existsByTipoIgnoreCase(cambios.getTipo())) {
            throw new EntityExistsException("Tipo ya existente: " + cambios.getTipo());
        }

        if (cambios.getTipo() != null) f.setTipo(cambios.getTipo());
        if (cambios.isActivo() != f.isActivo()) f.setActivo(cambios.isActivo());
        if (cambios.getNombreFormulario() != null) f.setNombreFormulario(cambios.getNombreFormulario());
        if (cambios.getPreguntas() != null) f.setPreguntas(cambios.getPreguntas());


        return f; // Dirty checking → UPDATE al commit
    }

    public void eliminar(Long id){
        Formulario f = get(id);

        //No permitir si tiene preguntas asociadas
        List<Pregunta> preguntas = preguntaRepository.findByFormularioId(id);
        if (!preguntas.isEmpty()){
            throw new EntityExistsException("No se puede eliminar: el formulario tiene preguntas asociadas");
        }

        formularioRepository.delete(f);
    }






}

