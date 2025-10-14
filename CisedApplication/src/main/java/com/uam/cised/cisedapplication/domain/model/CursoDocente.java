package com.uam.cised.cisedapplication.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "curso_docente",
        uniqueConstraints = @UniqueConstraint(name="uk_cursodocente_asig_doc", columnNames={"asignatura_id","docente_id"}),
        indexes = {
                @Index(name="ix_cursodocente_asignatura", columnList="asignatura_id"),
                @Index(name="ix_cursodocente_docente", columnList="docente_id")
        })
@Data @NoArgsConstructor @AllArgsConstructor
public class CursoDocente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "asignatura_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_cursodocente_asignatura"))
    private Asignatura asignatura;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "docente_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_cursodocente_docente"))
    private Docente docente;
}
