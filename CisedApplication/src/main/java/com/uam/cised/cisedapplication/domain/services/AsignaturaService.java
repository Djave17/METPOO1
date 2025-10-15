package com.uam.cised.cisedapplication.domain.services;

import com.uam.cised.cisedapplication.domain.model.Asignatura;
import com.uam.cised.cisedapplication.domain.model.Programa;
import com.uam.cised.cisedapplication.domain.repository.AsignaturaRepository;
import com.uam.cised.cisedapplication.domain.repository.ProgramaRepository;

import jakarta.persistence.EntityExistsException;   // Excepción estándar para duplicados
import jakarta.persistence.EntityNotFoundException;// Excepción estándar para no encontrado

import lombok.RequiredArgsConstructor;             // Lombok: genera constructor con final fields
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;      // @Service: marca clase de lógica de negocio
import org.springframework.transaction.annotation.Transactional; // @Transactional: maneja transacciones

@Service @RequiredArgsConstructor
public class AsignaturaService {

    private final AsignaturaRepository asignaturaRepository;
    private final ProgramaRepository programaRepository;

    @Transactional
    public Asignatura crearAsignatura(Long programaId, Asignatura asignaturaIn){
        Programa programa = programaRepository.findById(programaId).orElseThrow(()->
                new EntityNotFoundException("Programa no encontrado"));

        if (asignaturaIn != null && asignaturaRepository.existsByCodigoIgnoreCaseAndProgramaId(asignaturaIn.getCodigo(), programaId)){
            throw new EntityExistsException("El Codigo ya existe en el programa");
        }
        asignaturaIn.setPrograma(programa);
        return asignaturaRepository.save(asignaturaIn);
    }

    @Transactional(readOnly = true)
    public Asignatura get(Long id)
    {
        return asignaturaRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("La asignatura: no existe"));
    }

    @Transactional
    public Asignatura actualizar(Long id, Asignatura nuevaAsignatura) {
        Asignatura a = get(id);

        if(nuevaAsignatura.getCodigo() != null && !nuevaAsignatura.getCodigo().equalsIgnoreCase(a.getCodigo())
            && asignaturaRepository.existsByCodigoIgnoreCaseAndProgramaId(nuevaAsignatura.getCodigo(), a.getPrograma().getId())){
            throw new EntityExistsException("Codigo duplicado en el programa");
        }

        if(nuevaAsignatura.getNombre() != null && !nuevaAsignatura.getNombre().equalsIgnoreCase(a.getNombre())
            && asignaturaRepository.existsByNombreIgnoreCaseAndProgramaId(nuevaAsignatura.getNombre(), a.getPrograma().getId())){
            throw new EntityExistsException("Nombre duplicado en el programa");
        }

        if (nuevaAsignatura.getCodigo() != null) a.setCodigo(nuevaAsignatura.getCodigo());
        if (nuevaAsignatura.getNombre() != null) a.setNombre(nuevaAsignatura.getNombre());
        if (nuevaAsignatura.getEstado() != null) a.setEstado(nuevaAsignatura.getEstado());
        if (nuevaAsignatura.getFechaInicio() != null) a.setFechaInicio(nuevaAsignatura.getFechaInicio());
        if (nuevaAsignatura.getFechaFin() != null) a.setFechaFin(nuevaAsignatura.getFechaFin());


        return a;


    }




}
