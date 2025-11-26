package com.granum.InformeOpenXava.modelo;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import com.granum.InformeOpenXava.modelo.*;

import lombok.*;
import org.openxava.model.Identifiable;
@Entity @Getter @Setter
public class Categoria extends Identifiable {

    @Column(length=50)
    String descripcion;
 
}