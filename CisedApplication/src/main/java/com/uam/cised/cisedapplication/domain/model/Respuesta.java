package com.uam.cised.cisedapplication.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "respuesta",
        indexes = {
                @Index(name="ix_respuesta_evaluacion", columnList="evaluacion_id"),
                @Index(name="ix_respuesta_pregunta", columnList="pregunta_id")
        })
@Data @NoArgsConstructor @AllArgsConstructor
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50)
    @Column(length = 50)
    private String respuestasPosibles;       // Likert/SiNo/Texto corto

    @Size(max = 255)
    @Column(length = 255)
    private String observacion; // Comentario opcional

    // Relación muchos a uno con Evaluacion y Pregunta
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "evaluacion_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_respuesta_evaluacion"))
    private Evaluacion evaluacion;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "pregunta_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_respuesta_pregunta"))
    private Pregunta pregunta;
}
