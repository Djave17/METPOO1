package com.granum.InformeOpenXava.calculadores;



import org.openxava.calculators.*; // Para usar 'ICalculator'

import com.granum.InformeOpenXava.util.*; // Para usar 'PreferenciasFacturacion'

public class CalculadorPorcentajeIVA implements ICalculator {

    public Object calculate() throws Exception {
        return PreferenciasFacturacion.getPorcentajeIVADefecto();
    }
}