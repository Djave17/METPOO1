package com.uam.cised.cisedapplication.domain.model;

import jakarta.persistence.*;

@Entity
public class TipoFormulario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, unique=true, length=40) // “DOCENTE”, “ESTUDIANTE”, “ADMINISTRATIVO”
    private String codigo;

    @Column(nullable=false) // Nombre visible
    private String nombre;

    @Column(length=200)     // Opcional, para reportes/UI
    private String descripcion;

    public TipoFormulario() {}
    public TipoFormulario(String codigo, String nombre, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // getters/setters
    public Long getId() { return id; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }



}


