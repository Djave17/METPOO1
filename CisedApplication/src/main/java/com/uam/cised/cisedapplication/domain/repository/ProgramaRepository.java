package com.uam.cised.cisedapplication.domain.repository;

import com.uam.cised.cisedapplication.domain.model.Programa;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Page; //PAGE: Clase
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.List;


public interface ProgramaRepository {

    // Por nombre (opcionalmente dentro de una facultad)
    Optional<Programa> findByNombreIgnoreCaseAndFacultadId(String nombre, Long facultadId);
    List<Programa> findByFacultadId(Long facultadId);

    // Búsqueda paginada por facultad y/o texto\
    Page<Programa> findByFacultadId(Long facultadId, Pageable pageable);
    Page<Programa> findByNombreContainingIgnoreCase(String q, Pageable pageable);
    //Pageable quiere decir


    boolean existsByNombreIgnoreCaseAndFacultadId(String nombre, Long facultadId);

}
