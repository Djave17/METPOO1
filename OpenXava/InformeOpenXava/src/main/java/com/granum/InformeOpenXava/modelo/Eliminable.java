package com.granum.InformeOpenXava.modelo;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import com.granum.InformeOpenXava.modelo.*;

import lombok.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;
 
@MappedSuperclass @Getter @Setter
public class Eliminable extends Identificable {
 
    @Hidden
    @Column(columnDefinition="BOOLEAN DEFAULT FALSE")
    boolean eliminado;
 
}