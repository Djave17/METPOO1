package com.uam.cised.cisedapplication.domain.repository;

import com.uam.cised.cisedapplication.domain.model.NivelFormacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface NivelFormacionRepository extends JpaRepository<NivelFormacion, Long>{

    Optional<NivelFormacion> findByNombreIgnoreCase(String nombre);
    boolean existsByNombreIgnoreCase(String nombre);

}
