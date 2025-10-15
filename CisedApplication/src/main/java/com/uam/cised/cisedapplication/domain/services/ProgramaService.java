package com.uam.cised.cisedapplication.domain.services;

import com.uam.cised.cisedapplication.domain.model.Programa;
import com.uam.cised.cisedapplication.domain.model.Facultad;
import com.uam.cised.cisedapplication.domain.model.NivelFormacion;
import com.uam.cised.cisedapplication.domain.repository.ProgramaRepository;
import com.uam.cised.cisedapplication.domain.repository.FacultadRepository;
import com.uam.cised.cisedapplication.domain.repository.NivelFormacionRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.info.ProcessInfoContributor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service //Definimos el bean como servicio
@RequiredArgsConstructor

public class ProgramaService {

    private final ProgramaRepository programaRepository;
    private final FacultadRepository facultadRepository;
    private final NivelFormacionRepository nivelFormacionRepository;
    private final ProcessInfoContributor processInfoContributor;

    @Transactional(readOnly = true)
    public Programa crear(Long facultadId, Long nivelFormacionID, Programa programa){
        //Creamos objeto facultad y buscamos mediante JakartaPersistence, el id de la facultad
        //Para saber si existe
        Facultad facultad = facultadRepository.findById(facultadId).orElseThrow(() -> new
                EntityNotFoundException("Facultad  no encontrada"));
        NivelFormacion nivelFormacion = null ;
        if (nivelFormacionID != null) {
            nivelFormacion = nivelFormacionRepository.findById(nivelFormacionID).orElseThrow(() ->
                    new EntityNotFoundException("Nivel de formacion no encontrado"));
        }
        boolean programaExiste = programaRepository.existsByNombreIgnoreCaseAndFacultadId(programa.getNombre(), facultadId);
        if (programaExiste) throw new EntityExistsException("Ya existe un programa con ese nombre");

        programa.setFacultad(facultad);
        programa.setNivelFormacion(nivelFormacion);
        return programaRepository.save(programa);

    }

    @Transactional(readOnly = true)
    public Programa get(Long id){
        return programaRepository.findById(id).orElseThrow(() -> new
                EntityExistsException("Programa no existe"));

    }

    @Transactional
    public  Programa actualizar(Long id, Programa programaNuevo){
        Programa p = get(id);

        //Validaciones de unicidad
        if (programaNuevo.getNombre() != null && !programaNuevo.getNombre().
                equalsIgnoreCase(p.getNombre()) && programaRepository.existsByNombreIgnoreCaseAndFacultadId(programaNuevo.getNombre(), p.getFacultad().getId()))
        {
            throw new EntityExistsException("Nombre Existente en la facultada " + p.getFacultad().getNombre());
        }

        //Aplicar cambios permitidos
        if(programaNuevo.getNombre() != null)
            p.setNombre(programaNuevo.getNombre());
        if (programaNuevo.getNivelFormacion() != null)
            p.setNivelFormacion(programaNuevo.getNivelFormacion());
        return p;
    }

    @Transactional
    public void eliminar(Long id) {
        Programa p = get(id);
        programaRepository.delete(p);
    }
}
