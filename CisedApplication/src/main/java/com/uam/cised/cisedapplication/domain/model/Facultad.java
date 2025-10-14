package com.uam.cised.cisedapplication.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jdk.jfr.DataAmount;
import lombok.*;

import java.util.List;

@Entity(name = "facultad")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "facultad",
        uniqueConstraints = @UniqueConstraint(name="uk_facultad_nombre", columnNames="nombre"))
public class Facultad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// estrategia = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, unique = true, length = 200)
    private String nombre;

    @OneToMany(mappedBy = "facultad", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Programa> programas;
    public Facultad(String nombre) {
        this.nombre = nombre;
    }


    public Facultad (Long id, String nombre) {
        this.id = id;
    }
}
