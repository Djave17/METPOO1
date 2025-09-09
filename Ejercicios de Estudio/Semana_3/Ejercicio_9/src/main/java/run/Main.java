package run;

import java.util.Scanner;
import clases.Jugador;
import clases.Tablero;

import javax.xml.transform.Source;

public class Main
{


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Crear jugadores
        System.out.println("--- Tic Tac Toe ---");

        System.out.print("Ingrese el nombre del Jugador 1 (X): ");
        String nombre1 = sc.nextLine();
        Jugador jugador1 = new Jugador(nombre1, 'X');

        System.out.print("Ingrese el nombre del Jugador 2 (O): ");
        String nombre2 = sc.nextLine();
        Jugador jugador2 = new Jugador(nombre2, 'O');

        Tablero tablero = new Tablero();

        Jugador actual = jugador1;

        // Bucle principal del juego
        while (true) {
            limpiarPantalla();
            System.out.println("=== TIC-TAC-TOE ===");
            tablero.mostrarTablero();
            System.out.println("Turno de " + actual.getNombre() + " (" + actual.getFicha() + ")");

            // Leer jugada válida (0..2)
            int fila = leerEnteroEnRango(sc, "Ingrese la fila (0, 1, 2): ", 0, 2);
            int columna = leerEnteroEnRango(sc, "Ingrese la columna (0, 1, 2): ", 0, 2);

            // Intentar colocar la ficha; si está ocupada, se reintenta SIN cambiar de jugador
            if (!tablero.colocarFicha(fila, columna, actual.getFicha())) {
                System.out.println("Casilla ocupada. Intenta de nuevo...");
                pausa(sc);
                continue; // mismo jugador repite
            }

            // ¿Hay ganador?
            char g = tablero.verificarGanador();
            if (g != '\0') {
                limpiarPantalla();
                tablero.mostrarTablero();
                String nombreGanador = (g == jugador1.getFicha()) ? jugador1.getNombre() : jugador2.getNombre();
                System.out.println("¡Ganó " + nombreGanador + " (" + g + ")!");
                break;
            }

            // ¿Empate?
            if (tablero.estaLleno()) {
                limpiarPantalla();
                tablero.mostrarTablero();
                System.out.println("¡Empate!");
                break;
            }

            // Cambiar de jugador
            actual = (actual == jugador1) ? jugador2 : jugador1;
        }



    }
    /** Lee un entero en [min, max], reintentando si hay errores de formato o rango. */
    private static int leerEnteroEnRango(Scanner sc, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                int v = sc.nextInt();

                if (v >= min && v <= max) {
                    return v;
                }
                System.out.println("Valor fuera de rango. Debe estar entre " + min + " y " + max + ".");
            } else {
                System.out.println("Entrada inválida. Debes ingresar un número entero.");
                sc.next(); // descarta token no numérico
            }
        }
    }


    /** Limpia la pantalla en la mayoría de terminales compatibles con ANSI. */
    private static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /** Pequeña pausa para que el usuario lea el mensaje antes de refrescar. */
    private static void pausa(Scanner sc) {
        System.out.print("Presiona Enter para continuar...");
        sc.nextLine(); // consume fin de línea pendiente si viene de nextInt
        if (!sc.hasNextLine()) return;
        sc.nextLine();
    }




}


