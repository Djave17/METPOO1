package com.granum.InformeOpenXava.anotaciones; // En el paquete 'anotaciones'

import java.lang.annotation.*;

import javax.validation.*;

@Constraint(validatedBy = com.granum.InformeOpenXava.validador.ValidadorISBN.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ISBN {

    boolean buscar() default true; // Para (des)activar la búsqueda web al validar

    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default{};
    String message() default "isbn_invalido"; // Id del mensaje en el archivo i18n
}