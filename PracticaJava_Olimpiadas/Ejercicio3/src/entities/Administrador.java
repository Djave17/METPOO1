package entities;

import entities.Usuario;
// Clases concretas

public class Administrador extends Usuario {

    private final int nivelDeAcceso;

    public Administrador(int id, String nombre, String email, int nivelDeAcceso) {
        super(id, nombre, email);
        this.nivelDeAcceso = nivelDeAcceso;
    }

    public int getNivelDeAcceso() {
        return nivelDeAcceso;
    }

    @Override
    public TipoUsuario getTipo() {
        return TipoUsuario.ADMINISTRADOR;
    }

    @Override
    public String toString() {
        return String.format(
                "%s, nivelDeAcceso=%d",
                super.toString(),
                nivelDeAcceso
        );
    }
}