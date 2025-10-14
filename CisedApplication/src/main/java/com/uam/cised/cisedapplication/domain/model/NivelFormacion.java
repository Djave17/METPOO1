package com.uam.cised.cisedapplication.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Entity
@Table(name = "nivel_formacion",
      uniqueConstraints = @UniqueConstraint(name = "uk_nivel_formacion_nombre", columnNames = "nombre"))
@Data
@NoArgsConstructor
@AllArgsConstructor

public class NivelFormacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 40)
    private String nombre; // Maestría, Diplomado, Curso, Especialidad


}
