package com.uam.cised.cisedapplication.domain.services;


import com.uam.cised.cisedapplication.domain.model.Asignatura;
import com.uam.cised.cisedapplication.domain.model.CursoDocente;
import com.uam.cised.cisedapplication.domain.model.Docente;
import com.uam.cised.cisedapplication.domain.repository.AsignaturaRepository;
import com.uam.cised.cisedapplication.domain.repository.CursoDocenteRepository;
import com.uam.cised.cisedapplication.domain.repository.DocenteRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @RequiredArgsConstructor
public class CursoDocenteService {

    private final CursoDocenteRepository cursoDocenteRepository;
    private final AsignaturaRepository asignaturaRepository;
    private final DocenteRepository docenteRepository;

    @Transactional
    public CursoDocente asignar(Long asignaturaId, Long docenteId) {
        if (cursoDocenteRepository.existsByAsignaturaIdAndDocenteId(asignaturaId, docenteId)) {
            throw new EntityExistsException("Ya existe esa asignación");
        }
        Asignatura a = asignaturaRepository.findById(asignaturaId)
                .orElseThrow(() -> new EntityNotFoundException("Asignatura no existe"));
        Docente d = docenteRepository.findById(docenteId)
                .orElseThrow(() -> new EntityNotFoundException("Docente no existe"));

        CursoDocente cd = new CursoDocente();
        cd.setAsignatura(a);
        cd.setDocente(d);
        return cursoDocenteRepository.save(cd);
    }



}
