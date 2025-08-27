package run;

import java.util.Scanner;

public class Utils {

    private static final Scanner SCANNER = new Scanner(System.in);

    // Limpia la consola de forma multiplataforma cuando es posible.
    // Intenta primero con códigos ANSI; si no funciona, usa comandos del SO.
    public static void limpiarConsola() {
        try {
            // Secuencia ANSI para limpiar y mover el cursor al inicio
            System.out.print("\033[H\033[2J");
            System.out.flush();

            // Como respaldo, intentar comando del sistema operativo
            String os = System.getProperty("os.name").toLowerCase();
            ProcessBuilder pb;
            if (os.contains("win")) {
                pb = new ProcessBuilder("cmd", "/c", "cls");
            } else {
                pb = new ProcessBuilder("bash", "-lc", "clear");
            }
            pb.inheritIO();
            Process p = pb.start();
            p.waitFor();
        } catch (Exception ignored) {
            // Si no se puede limpiar, no interrumpimos la ejecución.
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }

    // Metodo utilitario robusto para leer enteros desde la consola
    public static int leerEntero(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = SCANNER.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingresa un número entero.");
            }
        }
    }


}
