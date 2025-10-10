package Interfaces;

import Models.Visit;

import java.util.ArrayList;

public interface IVisita {

    public void agregar(Visit visita);

    ArrayList<Visit> obtenerVisitas();
}
