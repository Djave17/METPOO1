package com.granum.InformeOpenXava.modelo;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import com.granum.InformeOpenXava.modelo.*;

import lombok.*;
import javax.persistence.*;

import lombok.*;
 
@Embeddable // Usamos @Embeddable en vez de @Entity
@Getter @Setter
public class Direccion {
 
    @Column(length = 30) // Los miembros se anotan igual que en las entidades
    String viaPublica;
 
    @Column(length = 5)
    int codigoPostal;
 
    @Column(length = 20)
    String municipio;
 
    @Column(length = 30)
    String provincia;
 
}