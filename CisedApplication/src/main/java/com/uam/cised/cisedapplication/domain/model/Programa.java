package com.uam.cised.cisedapplication.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Entity(name = "programa")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Programa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    @Column(nullable = false, unique = true, length = 250)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "facultad_id")
    private Facultad facultad;
}
