package com.uam.cised.cisedapplication.domain.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "evaluacion",
        indexes = {
                @Index(name="ix_evaluacion_curso_docente", columnList = "curso_docente_id"),
                @Index(name="ix_evaluacion_formulario", columnList = "formulario_id")
        })
@Data @NoArgsConstructor @AllArgsConstructor
public class Evaluacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_docente_id", nullable = false, //Se asigna el id del curso que imparte el docente.
            // Se agrega la columna curso_docente_id y se crea como FK
            foreignKey = @ForeignKey(name = "fk_evaluacion_cursoDocente"))
    private CursoDocente cursoDocente;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "formulario_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_evaluacion_formulario"))
    private Formulario formulario;

    @Column(name = "fecha_respuesta", nullable = false) //TODO: revisar zona horaria, formato, sintaxis
    private OffsetDateTime fechaRespuesta = OffsetDateTime.now();

}