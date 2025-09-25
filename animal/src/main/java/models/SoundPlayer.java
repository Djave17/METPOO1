package models;

import javazoom.jl.player.Player;
import java.io.InputStream;

/**
 * Reproduce archivos MP3 empaquetados en resources usando JLayer.
 * Ejemplo de uso:
 *   SoundPlayer.playResource("/sounds/cat.mp3");
 */
public final class SoundPlayer {
    private SoundPlayer() {}

    public static void playResource(String resourcePath) {
        try (InputStream in = SoundPlayer.class.getResourceAsStream(resourcePath)) {
            if (in == null) {
                throw new IllegalStateException("No se encontró el recurso: " + resourcePath +
                        " (¿está en src/main/resources" + resourcePath + "?)");
            }
            new Player(in).play(); // bloquea hasta terminar
        } catch (Exception e) {
            throw new RuntimeException("Error reproduciendo " + resourcePath, e);
        }
    }
}
