package com.uam.cised.cisedapplication.domain.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Entity(name = "tipo_pregunta")
@Data
@AllArgsConstructor
public class TipoPregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length=40)     // SI_NO, ESCALA_1_5, TEXTO_LIBRE
    private String codigo;



    public TipoPregunta(String codigo) {
        this.codigo = codigo;
    }

    public TipoPregunta() {}


    //Getters and Setters
    public Long getId() { return id; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }




}
