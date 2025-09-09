/*Tablero de Juego (Tic-Tac-Toe)
Objetivo: Clase Tablero que use una matriz 3x3 de caracteres.
•    Métodos para colocar ficha, verificar ganador, y mostrar tablero.
•    Usa una clase Jugador para registrar nombre y ficha (‘X’ o ‘O’).*/


package clases;

public class Tablero {
    /*
    *N es una constante de instancia: no podrás hacer N = 4;
    *Final quiere decir hacer inmutable un atributo de clase.
    */
    private final int N = 3;
    private char[][] matriz = new char[N][N];

    public Tablero() {
        // inicializa con espacios
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matriz[i][j] = ' ';
            }
        }
    }

    /**
     * Coloca una ficha en (fila, col) si es válido y está libre.
     * @return true si se colocó, false si la celda ya estaba ocupada.
     */

    public boolean colocarFicha(int fila, int columna, char ficha) {
        //validarIndices(fila, columna);
        if (matriz[fila][columna] != ' ') {
            return false;
        }
        char f = Character.toUpperCase(ficha);
        if (f != 'X' && f != 'O') {
           return false; // ficha inválida
        }
        matriz[fila][columna] = f;
        return true;
    }


    /**
     * Verifica si hay ganador. Retorna 'X' u 'O' si hay tres en línea,
     * o '\0' (carácter nulo) si no hay ganador.
     */

    public char verificarGanador() {

        // --- Filas ---
        for (int i = 0; i < N; i++) {
            char a = matriz[i][0];
            char b = matriz[i][1];
            char c = matriz[i][2];

            if (a != ' ' && a == b && b == c) {
                return a; // 'X' u 'O'
            }
        }

        // --- Columnas ---
        for (int j = 0; j < N; j++) {
            char a = matriz[0][j];
            char b = matriz[1][j];
            char c = matriz[2][j];

            if (a != ' ' && a == b && b == c) {
                return a; // 'X' u 'O'
            }
        }

        // --- Diagonales ---
        char centro = matriz[1][1];
        if (centro != ' ') {
            // diagonal principal (0,0)-(1,1)-(2,2)
            if (centro == matriz[0][0] && centro == matriz[2][2]) {
                return centro;
            }
            // diagonal secundaria (0,2)-(1,1)-(2,0)
            if (centro == matriz[0][2] && centro == matriz[2][0]) {
                return centro;
            }
        }

        // Sin ganador
        //null
        return '\0';
    }





    public void mostrarTablero() {
        for (int i = 0; i < N; i++) {
            System.out.printf(" %c | %c | %c %n", matriz[i][0], matriz[i][1], matriz[i][2]);
            if (i < N - 1) {
                System.out.println("---+---+---");
            }
        }
    }




    /*
     * Metodos de verificacion de datos
     * Validar indice de fila y columna
     * Esta lleno el tablero
     */
    public boolean validarIndices(int fila, int columna) {
        if (fila < 0 || fila >= N || columna < 0 || columna >= N || matriz[fila][columna] != ' ') {
            return false;
        }


        return false;
    }

    public boolean estaLleno() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matriz[i][j] == ' ') return false; // hay al menos un espacio
            }
        }
        return true; // no hay espacios libres
    }

    /** Retorna true si no hay celdas libres */
    public boolean celdaEstaLlena() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matriz[i][j] == ' ') {
                    return true; //Si esta lleno retorna true
                }
            }
        }
        return true;
    }






}
