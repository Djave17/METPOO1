package Run;
import Models.Student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear arreglo de 3 estudiantes
        Student[] students = new Student[3];

        for (int i = 0; i < students.length; i++) {
            System.out.println("\n--- Registro del estudiante " + (i + 1) + " ---");

            String name, career, id;
            boolean validInput;

            // Nombre
            do {
                System.out.print("Ingrese el nombre: ");
                name = scanner.nextLine();
                try {
                    new Student().setName(name); // validamos sin perder objeto
                    validInput = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                    validInput = false;
                }
            } while (!validInput);

            // Carrera
            do {
                System.out.print("Ingrese la carrera: ");
                career = scanner.nextLine();
                try {
                    new Student().setCareer(career);
                    validInput = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                    validInput = false;
                }
            } while (!validInput);

            // ID (8 dígitos)
            do {
                System.out.print("Ingrese el id (8 dígitos): ");
                id = scanner.nextLine();
                try {
                    new Student().setId(id);
                    validInput = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                    validInput = false;
                }
            } while (!validInput);

            // Crear objeto definitivo
            students[i] = new Student(name, career, id);
        }

        // Imprimir estudiantes registrados
        System.out.println("\n=== Estudiantes registrados en UAM ===");
        for (Student s : students) {
            System.out.println(s);
        }

        scanner.close();
    }
}

