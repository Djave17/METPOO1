package com.uam.cised.cisedapplication.domain.repository;

import com.uam.cised.cisedapplication.domain.model.Facultad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;


//Se crea interfaz que hereda de JpaRepository para manejar las operaciones CRUD de la entidad Facultad
//Esta hereda de JpaRepository para poder realizar las operaciones CRUD de la entidad Facultad
public interface FacultadRepository extends JpaRepository<Facultad, Long> {

    //Optional:
    Optional<Facultad> findByNombreIgnoreCase(String nombre); //Busca una facultad por su nombre, ignorando mayúsculas y minúsculas
    boolean existsByNombreIgnoreCase(String nombre); //Verifica si existe una facultad con el nombre dado, ignorando mayúsculas y minúsculas
    List<Facultad> findByNombreContainingIgnoreCase(String nombre); //Busca facultades cuyo nombre contenga la cadena dada, ignorando mayúsculas y minúsculas
    List<Facultad> findAllByOrderByNombreAsc();

}
