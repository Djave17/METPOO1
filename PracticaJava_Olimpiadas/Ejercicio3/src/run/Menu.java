package run;

import entities.Administrador;
import entities.Editor;
import entities.Lector;
import entities.TipoUsuario;
import entities.Usuario;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Menu {

    private static final Map<Integer, Usuario> usuarios = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void menu() {

        int opcion;

        do {
            System.out.println("----- Administracion de usuarios ----");
            System.out.println("1. Crear usuario");
            System.out.println("2. Listar usuarios por tipo");
            System.out.println("3. Listar usuarios por nombre");
            System.out.println("4. Mostrar reporte por tipo de usuario");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Opción inválida. Ingrese un número:");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> crearUsuario();
                case 2 -> listarUsuariosPorTipo();
                case 3 -> listarUsuariosPorNombre();
                case 4 -> mostrarReportePorTipo();
                case 0 -> System.out.println("Saliendo del menú...");
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }

            System.out.println();

        } while (opcion != 0);
    }

    private static void crearUsuario() {
        System.out.println("Seleccione el tipo de usuario:");
        System.out.println("1. Administrador");
        System.out.println("2. Editor");
        System.out.println("3. Lector");
        System.out.print("Opción: ");

        int tipoOpcion;
        while (!scanner.hasNextInt()) {
            System.out.println("Opción inválida. Ingrese un número:");
            scanner.next();
        }
        tipoOpcion = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese id: ");
        int id;
        while (!scanner.hasNextInt()) {
            System.out.println("Id inválido. Ingrese un número:");
            scanner.next();
        }
        id = scanner.nextInt();
        scanner.nextLine();

        if (usuarios.containsKey(id)) {
            System.out.println("Ya existe un usuario con ese id.");
            return;
        }

        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese email: ");
        String email = scanner.nextLine();

        Usuario nuevoUsuario;

        switch (tipoOpcion) {
            case 1 -> {
                System.out.print("Ingrese nivel de acceso (entero): ");
                int nivel;
                while (!scanner.hasNextInt()) {
                    System.out.println("Valor inválido. Ingrese un número:");
                    scanner.next();
                }
                nivel = scanner.nextInt();
                scanner.nextLine();
                nuevoUsuario = new Administrador(id, nombre, email, nivel);
            }
            case 2 -> {
                System.out.print("Ingrese secciones asignadas separadas por coma: ");
                String line = scanner.nextLine();
                String[] partes = line.split(",");
                List<String> secciones = new ArrayList<>();
                for (String p : partes) {
                    String s = p.trim();
                    if (!s.isEmpty()) {
                        secciones.add(s);
                    }
                }
                nuevoUsuario = new Editor(id, nombre, email, secciones);
            }
            case 3 -> {
                System.out.print("Ingrese temas favoritos separados por coma: ");
                String line = scanner.nextLine();
                String[] partes = line.split(",");
                Set<String> temas = new java.util.HashSet<>();
                for (String p : partes) {
                    String s = p.trim();
                    if (!s.isEmpty()) {
                        temas.add(s);
                    }
                }
                nuevoUsuario = new Lector(id, nombre, email, temas);
            }
            default -> {
                System.out.println("Tipo de usuario no válido.");
                return;
            }
        }

        agregarUsuario(nuevoUsuario);
        System.out.println("Usuario creado y guardado correctamente.");
    }

    private static void agregarUsuario(Usuario usuario) {
        usuarios.put(usuario.getId(), usuario);
    }

    private static void listarUsuariosPorTipo() {
        System.out.println("Seleccione el tipo a listar:");
        System.out.println("1. Administrador");
        System.out.println("2. Editor");
        System.out.println("3. Lector");
        System.out.print("Opción: ");

        int tipoOpcion;
        while (!scanner.hasNextInt()) {
            System.out.println("Opción inválida. Ingrese un número:");
            scanner.next();
        }
        tipoOpcion = scanner.nextInt();
        scanner.nextLine();

        TipoUsuario tipo;
        switch (tipoOpcion) {
            case 1 -> tipo = TipoUsuario.ADMINISTRADOR;
            case 2 -> tipo = TipoUsuario.EDITOR;
            case 3 -> tipo = TipoUsuario.LECTOR;
            default -> {
                System.out.println("Tipo no válido.");
                return;
            }
        }

        boolean encontrado = false;
        System.out.println("=== Usuarios de tipo " + tipo + " ===");
        for (Usuario u : usuarios.values()) {
            if (u.getTipo() == tipo) {
                System.out.println(u);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No hay usuarios del tipo seleccionado.");
        }
    }

    private static void listarUsuariosPorNombre() {
        List<Usuario> lista = new ArrayList<>(usuarios.values());
        lista.sort(
                Comparator.comparing(
                                (Usuario u) -> u.getNombre().toLowerCase()
                        )
                        .thenComparing(u -> u.getTipo().name())
                        .thenComparingInt(Usuario::getId)
        );

        if (lista.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }

        System.out.println("=== Usuarios ordenados alfabéticamente ===");
        for (Usuario u : lista) {
            System.out.println(u);
        }
    }

    private static void mostrarReportePorTipo() {
        int totalAdmins = 0;
        int totalEditores = 0;
        int totalLectores = 0;

        for (Usuario u : usuarios.values()) {
            if (u.getTipo() == TipoUsuario.ADMINISTRADOR) {
                totalAdmins++;
            } else if (u.getTipo() == TipoUsuario.EDITOR) {
                totalEditores++;
            } else if (u.getTipo() == TipoUsuario.LECTOR) {
                totalLectores++;
            }
        }

        System.out.println("Administradores: " + totalAdmins);
        System.out.println("Editores: " + totalEditores);
        System.out.println("Lectores: " + totalLectores);
        System.out.println("Total de usuarios: " + usuarios.size());
    }
}
