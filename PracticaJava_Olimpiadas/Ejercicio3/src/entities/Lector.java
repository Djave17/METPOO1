package entities;
import entities.*;
import java.util.Set;
import java.util.stream.Collectors;

public class Lector extends Usuario {

    private final Set<String> temasFavoritos;

    public Lector(int id, String nombre, String email, Set<String> temasFavoritos) {
        super(id, nombre, email);
        this.temasFavoritos = Set.copyOf(temasFavoritos);
    }

    public Set<String> getTemasFavoritos() {
        return temasFavoritos;
    }

    @Override
    public TipoUsuario getTipo() {
        return TipoUsuario.LECTOR;
    }

    @Override
    public String toString() {
        String temas = temasFavoritos.stream()
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .collect(Collectors.joining(" | "));
        return String.format(
                "%s, temasFavoritos=%s",
                super.toString(),
                temas
        );
    }
}