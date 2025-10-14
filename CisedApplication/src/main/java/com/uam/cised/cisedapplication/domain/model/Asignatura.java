package com.uam.cised.cisedapplication.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "asignatura",
        uniqueConstraints = {
                @UniqueConstraint(name="uk_asignatura_codigo_programa", columnNames={"codigo","programa_id"}),
                @UniqueConstraint(name="uk_asignatura_nombre_programa", columnNames={"nombre","programa_id"})
        },
        indexes = @Index(name="ix_asignatura_programa", columnList = "programa_id"))
@Data @NoArgsConstructor @AllArgsConstructor
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 20)
    @Column(length = 20)
    private String codigo;

    @NotBlank
    @Size(max = 150)
    @Column(nullable = false, length = 150)
    private String nombre;

    @Min(0)
    @Column(name = "cantidad_estudiantes")
    private Integer cantidadEstudiantes;

    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    @Column(nullable = false)
    private Boolean estado = Boolean.TRUE;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "programa_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_asignatura_programa"))
    private Programa programa;
}
