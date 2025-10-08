package uam.edu.ni.jpa.util;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import java.time.LocalDate;

import java.util.Scanner;
public class ConsoleIO {
    private final Scanner sc = new Scanner(System.in);

    public String readLine(String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }

    public int readInt(String prompt) {
        while (true) {
            try {
                return Integer.parseInt(readLine(prompt));
            } catch (NumberFormatException e) {
                System.out.println(" Ingresa un número entero válido.");
            }
        }
    }

    public double readDouble(String prompt) {
        while (true) {
            try {
                // permite 8 ó 8,5 (coma → punto)
                String s = readLine(prompt).replace(',', '.');
                return Double.parseDouble(s);
            } catch (NumberFormatException e) {
                System.out.println(" Ingresa un número (0-10) válido.");
            }
        }
    }

    public LocalDate readDate(String prompt) {
        while (true) {
            try {
                return LocalDate.parse(readLine(prompt), DateTimeFormatter.ISO_LOCAL_DATE);
            } catch (DateTimeParseException e) {
                System.out.println(" Formato esperado yyyy-mm-dd. Ej: 2025-03-23");
            }
        }
    }
}
