package com.tuempresa.facturacion.modelo;

import java.time.*;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.*;
import org.openxava.calculators.*;
import lombok.*;

@View(members= // Esta vista no tiene nombre, por tanto será la vista usada por defecto
        "anyo, numero, fecha;" + // Separados por coma significa en la misma línea
                "cliente;" + // Punto y coma significa nueva línea
                "detalles;" +
                "observaciones"
)
@Entity @Getter @Setter
public class Factura {

    @Id
    @GeneratedValue(generator="system-uuid")
    @Hidden
    @GenericGenerator(name="system-uuid", strategy="uuid")
    @Column(length=32)
    String oid;

    @Column(length=4)
    @DefaultValueCalculator(CurrentYearCalculator.class) // Año actual
    int anyo;

    @Column(length=6)
    int numero;

    @Required
    @DefaultValueCalculator(CurrentLocalDateCalculator.class) // Fecha actual
    LocalDate fecha;

    @TextArea
    String observaciones;

}
