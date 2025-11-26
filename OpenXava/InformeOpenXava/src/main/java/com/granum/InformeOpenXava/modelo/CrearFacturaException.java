package com.granum.InformeOpenXava.modelo;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import com.granum.InformeOpenXava.modelo.*;

import lombok.*;
import org.openxava.util.XavaResources;

public class CrearFacturaException extends Exception { // No RuntimeException

    public CrearFacturaException(String mensaje) {
        // El XavaResources es para traducir el mensaje desde el id en i18n
        super(XavaResources.getString(mensaje));
    }
	
}