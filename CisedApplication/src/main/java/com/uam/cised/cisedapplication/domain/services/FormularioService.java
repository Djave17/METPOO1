package com.uam.cised.cisedapplication.domain.services;

import com.uam.cised.cisedapplication.domain.model.Formulario;
import com.uam.cised.cisedapplication.domain.model.Pregunta;
import com.uam.cised.cisedapplication.domain.model.TipoFormulario;
import com.uam.cised.cisedapplication.domain.repository.FormularioRepository;
import com.uam.cised.cisedapplication.domain.repository.PreguntaRepository;

import jakarta.persistence.EntityExistsException;        // Excepción estándar si hay duplicidad
import jakarta.persistence.EntityNotFoundException;     // Excepción estándar si no existe el recurso
import jakarta.validation.Valid;                        // @Valid para validar DTO/entidad de entrada (si la usas)
import lombok.RequiredArgsConstructor;                  // Genera constructor con final fields
import org.springframework.stereotype.Service;          // Marca clase como servicio de negocio
import org.springframework.transaction.annotation.Transactional; // Manejo de transacciones

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FormularioService {
    private final FormularioRepository formularioRepository;
    private final PreguntaRepository preguntaRepository;


    // ==========================
    // Crear
    // ==========================

    /**
     * Crea un formulario recibiendo el tipo como ENUM (ideal si tu DTO ya trae TipoFormulario).
     * Valida unicidad por tipo.
     */
    @Transactional
    public Formulario crearFormulario(Formulario in) {
        if (in.getTipo() == null) {
            throw new IllegalArgumentException("El campo 'tipo' es requerido");
        }
        if (formularioRepository.existsByTipo(in.getTipo())) {
            throw new EntityExistsException("Ya existe un formulario con tipo: " + in.getTipo());
        }
        return formularioRepository.save(in); // INSERT
    }

    /**
     * Variante que crea un formulario recibiendo 'tipo' como String (útil si tu API recibe texto).
     * Convierte a enum y valida unicidad.
     */
    @Transactional
    public Formulario crearDesdeTexto(String tipoTexto, @Valid Formulario in) {
        TipoFormulario tipo = toTipoEnum(tipoTexto);
        if (formularioRepository.existsByTipo(tipo)) {
            throw new EntityExistsException("Ya existe un formulario con tipo: " + tipo);
        }
        in.setTipo(tipo);
        return formularioRepository.save(in);
    }

    @Transactional(readOnly = true)      // Solo lectura: no abre transacción de escritura
    public Formulario get(Long id) {
        return formularioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Formulario no existe"));
    }
    // ==========================
    // Actualizar
    // ==========================

    /**
     * Actualiza el tipo del formulario comparando versión optimista.
     * - Si versionCliente no coincide con la versión en BD, lanza ObjectOptimisticLockingFailureException (409).
     * - Si cambia el tipo a uno que ya existe, lanza EntityExistsException (duplicidad).
     * - Dirty checking hará el UPDATE y @Version incrementará automáticamente.
     */
    @Transactional
    public Formulario actualizarTipo(Long id, Long versionCliente, String tipoTextoNuevo) {
        Formulario f = get(id);

        // Chequeo de versión (opcional si tu ControllerAdvice ya traduce la excepción por @Version)
        if (versionCliente != null && !versionCliente.equals(f.getVersion())) {
            throw new org.springframework.orm.ObjectOptimisticLockingFailureException(Formulario.class, id);
        }

        // Convertir y validar duplicidad solo si cambia
        if (tipoTextoNuevo != null) {
            TipoFormulario nuevo = toTipoEnum(tipoTextoNuevo);
            if (!nuevo.equals(f.getTipo()) && formularioRepository.existsByTipo(nuevo)) {
                throw new EntityExistsException("Ya existe un formulario con tipo: " + nuevo);
            }
            f.setTipo(nuevo); // Dirty checking → UPDATE (incrementa @Version)
        }

        return f;
    }

    /**
     * Variante de actualizar que recibe el enum directamente.
     */
    @Transactional
    public Formulario actualizarTipo(Long id, Long versionCliente, TipoFormulario tipoNuevo) {
        Formulario f = get(id);

        if (versionCliente != null && !versionCliente.equals(f.getVersion())) {
            throw new org.springframework.orm.ObjectOptimisticLockingFailureException(Formulario.class, id);
        }

        if (tipoNuevo != null && !tipoNuevo.equals(f.getTipo()) && formularioRepository.existsByTipo(tipoNuevo)) {
            throw new EntityExistsException("Ya existe un formulario con tipo: " + tipoNuevo);
        }
        if (tipoNuevo != null) {
            f.setTipo(tipoNuevo); // Dirty checking → UPDATE
        }

        return f;
    }


    @Transactional
    public Formulario actualizar(Long id, @Valid Formulario cambios) {
        Formulario f = get(id); // Entidad "managed"

        if (cambios.getTipo() != null &&
                !cambios.getTipo().equals(f.getTipo()) &&
                formularioRepository.existsByTipo(cambios.getTipo())) {
            throw new EntityExistsException("Tipo ya existente: " + cambios.getTipo());
        }

        if (cambios.getTipo() != null) f.setTipo(cambios.getTipo());
        if (cambios.isActivo() != f.isActivo()) f.setActivo(cambios.isActivo());
        if (cambios.getNombreFormulario() != null) f.setNombreFormulario(cambios.getNombreFormulario());
        if (cambios.getPreguntas() != null) f.setPreguntas(cambios.getPreguntas());


        return f; // Dirty checking → UPDATE al commit
    }

    // ==========================
    // Eliminar
    // ==========================

    /**
     * Elimina un formulario solo si no tiene preguntas asociadas.
     * Política conservadora para evitar dejar huérfanas respuestas/preguntas.
     */
    public void eliminar(Long id){
        Formulario f = get(id);

        //No permitir si tiene preguntas asociadas
        List<Pregunta> preguntas = preguntaRepository.findByFormularioId(id);
        if (!preguntas.isEmpty()){
            throw new EntityExistsException("No se puede eliminar: el formulario tiene preguntas asociadas");
        }

        formularioRepository.delete(f);
    }

    // ==========================
    // Utilidades de conversión
    // ==========================

    /**
     * Convierte un texto a TipoFormulario de forma segura (case-insensitive).
     * Lanza IllegalArgumentException si el valor no es válido.
     */
    private TipoFormulario toTipoEnum(String raw) {
        if (raw == null) throw new IllegalArgumentException("El campo 'tipo' es requerido");
        try {
            return TipoFormulario.valueOf(raw.trim().toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException(
                    "TipoFormulario inválido: " + raw +
                            ". Valores válidos: " + Arrays.toString(TipoFormulario.values())
            );
        }
    }





}

