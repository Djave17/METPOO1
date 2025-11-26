/* Crea un sistema que administre tres tipos de usuarios:
Administrador, Editor y Lector. Todos heredan de una clase
base Usuario que contiene: id, nombre y email.
 Cada tipo agrega: - Administrador: nivelDeAcceso (int) - Editor: seccionesAsignadas (List<String>) - Lector: temasFavoritos (Set<String>) 
 El programa debe: 1. Guardar usuarios en un Map<Integer, Usuario> usando el id como clave. 
 2. Permitir agregar usuarios. 
 3. Listar todos los usuarios ordenados por el nombre (alfabéticamente). 
 4. Mostrar un reporte indicando cuántos usuarios hay por tipo.
 */
package entities;
import entities.TipoUsuario;

import java.util.List;
import java.util.Set;

public abstract class Usuario {

    private final int id;
    private final String nombre;
    private final String email;

    protected Usuario(int id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public abstract TipoUsuario getTipo();

    @Override
    public String toString() {
        return String.format(
                "[%-12s] id=%d, nombre='%s', email='%s'",
                getTipo(), id, nombre, email
        );
    }






}
