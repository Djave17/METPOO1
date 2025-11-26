package entities;

import entities.*;
import java.util.List;

public  class Editor extends Usuario {

    private final List<String> seccionesAsignadas;

    public Editor(int id, String nombre, String email, List<String> seccionesAsignadas) {
        super(id, nombre, email);
        this.seccionesAsignadas = List.copyOf(seccionesAsignadas);
    }

    public List<String> getSeccionesAsignadas() {
        return seccionesAsignadas;
    }

    @Override
    public TipoUsuario getTipo() {
        return TipoUsuario.EDITOR;
    }

    @Override
    public String toString() {
        return String.format(
                "%s, secciones=%s",
                super.toString(),
                String.join(" | ", seccionesAsignadas)
        );
    }
}