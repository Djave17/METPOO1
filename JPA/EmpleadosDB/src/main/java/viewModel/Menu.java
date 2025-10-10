package viewModel;

import config.JPAUtil;
import entities.Cargo;
import entities.Empleado;
import jakarta.persistence.EntityManager;
import repository.dao.CargoDao;
import repository.dao.EmpleadoDao;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private final CargoDao cargoDao;
    private final EmpleadoDao empleadoDao;
    private final Scanner sc = new Scanner(System.in);

    public Menu(EntityManager em) {
        this.cargoDao = new CargoDao(em);
        this.empleadoDao = new EmpleadoDao(em);
    }

    public void iniciar() {
        int opcion;
        do {
            System.out.println("\n===== GESTIÓN EMPLEADOS Y CARGOS =====");
            System.out.println("1. Menú Empleados");
            System.out.println("2. Menú Cargos");
            System.out.println("3. Listar todos los empleados con su cargo");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = leerEnteroSeguro();

            switch (opcion) {
                case 1 -> menuEmpleado();
                case 2 -> menuCargo();
                case 3 -> listarEmpleadosConCargo();
                case 4 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 4);
    }

    private void menuEmpleado() {
        int opcion;
        do {
            System.out.println("\n--- MENÚ EMPLEADOS ---");
            System.out.println("1. Listar Empleados");
            System.out.println("2. Agregar Empleado");
            System.out.println("3. Actualizar Empleado");
            System.out.println("4. Eliminar Empleado");
            System.out.println("5. Volver");
            System.out.print("Seleccione una opción: ");

            opcion = leerEnteroSeguro();

            switch (opcion) {
                case 1 -> listarEmpleados();
                case 2 -> agregarEmpleado();
                case 3 -> actualizarEmpleado();
                case 4 -> eliminarEmpleado();
                case 5 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 5);
    }

    private void menuCargo() {
        int opcion;
        do {
            System.out.println("\n--- MENÚ CARGOS ---");
            System.out.println("1. Listar Cargos");
            System.out.println("2. Agregar Cargo");
            System.out.println("3. Actualizar Cargo");
            System.out.println("4. Eliminar Cargo");
            System.out.println("5. Volver");
            System.out.print("Seleccione una opción: ");

            opcion = leerEnteroSeguro();

            switch (opcion) {
                case 1 -> listarCargos();
                case 2 -> agregarCargo();
                case 3 -> actualizarCargo();
                case 4 -> eliminarCargo();
                case 5 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 5);
    }

    // ----------------- CARGOS -----------------

    private void listarCargos() {
        List<Cargo> cargos = cargoDao.listarCargos();
        if (cargos.isEmpty()) {
            System.out.println("No hay cargos registrados.");
            return;
        }
        System.out.println("\n--- LISTA DE CARGOS ---");
        cargos.forEach(c -> System.out.printf("ID: %d | Cargo: %s%n", c.getId(), c.getNombreCargo()));
    }

    private void agregarCargo() {
        System.out.print("Ingrese el nombre del cargo: ");
        String nombre = sc.nextLine().trim();

        if (nombre.isEmpty()) {
            System.out.println("El nombre no puede estar vacío.");
            return;
        }

        Cargo cargo = new Cargo(nombre);
        cargoDao.guardarCargo(cargo);
        System.out.println("Cargo agregado exitosamente.");
    }

    private void actualizarCargo() {
        listarCargos();
        System.out.print("Ingrese el ID del cargo a actualizar: ");
        Long id = leerLongSeguro();

        Cargo cargoExistente = cargoDao.buscarCargoPorId(id);
        if (cargoExistente == null) {
            System.out.println("No se encontró el cargo.");
            return;
        }

        System.out.print("Nuevo nombre del cargo: ");
        String nuevoNombre = sc.nextLine().trim();
        if (!nuevoNombre.isEmpty()) {
            cargoExistente = new Cargo(nuevoNombre);
            cargoExistente = cargoDao.guardarCargo(cargoExistente);
            System.out.println("Cargo actualizado correctamente.");
        } else {
            System.out.println("El nombre no puede estar vacío.");
        }
    }

    private void eliminarCargo() {
        listarCargos();
        System.out.print("Ingrese el ID del cargo a eliminar: ");
        Long id = leerLongSeguro();
        cargoDao.eliminarCargo(id);
        System.out.println("Cargo eliminado exitosamente.");
    }

    // ----------------- EMPLEADOS -----------------

    private void listarEmpleados() {
        List<Empleado> empleados = empleadoDao.listarEmpleados();
        if (empleados == null || empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
            return;
        }
        System.out.println("\n--- LISTA DE EMPLEADOS ---");
        empleados.forEach(e -> System.out.printf("ID: %d | Nombre: %s | Salario: %.2f | Cargo: %s%n",
                e.getId(), e.getNombreEmpleado(), e.getSalario(), e.getCargo().getNombreCargo()));
    }

    private void agregarEmpleado() {
        System.out.print("Nombre del empleado: ");
        String nombre = sc.nextLine().trim();
        if (nombre.isEmpty()) {
            System.out.println("El nombre no puede estar vacío.");
            return;
        }

        System.out.print("Salario: ");
        Double salario = leerDoubleSeguro();

        listarCargos();
        System.out.print("Ingrese el ID del cargo: ");
        Long idCargo = leerLongSeguro();

        Cargo cargo = cargoDao.buscarCargoPorId(idCargo);
        if (cargo == null) {
            System.out.println("Cargo no encontrado.");
            return;
        }

        Empleado nuevoEmpleado = new Empleado(nombre, salario, cargo);
        empleadoDao.guardarEmpleado(nuevoEmpleado);
        System.out.println("Empleado agregado correctamente.");
    }

    private void actualizarEmpleado() {
        listarEmpleados();
        System.out.print("Ingrese el ID del empleado a actualizar: ");
        Long id = leerLongSeguro();

        Empleado emp = empleadoDao.buscarEmpleadoPorId(id);
        if (emp == null) {
            System.out.println("Empleado no encontrado.");
            return;
        }

        System.out.print("Nuevo nombre (enter para mantener): ");
        String nuevoNombre = sc.nextLine().trim();
        if (!nuevoNombre.isEmpty()) emp.setNombreEmpleado(nuevoNombre);

        System.out.print("Nuevo salario (0 para mantener): ");
        Double nuevoSalario = leerDoubleSeguro();
        if (nuevoSalario > 0) emp.setSalario(nuevoSalario);

        empleadoDao.guardarEmpleado(emp);
        System.out.println("Empleado actualizado correctamente.");
    }

    private void eliminarEmpleado() {
        listarEmpleados();
        System.out.print("Ingrese el ID del empleado a eliminar: ");
        Long id = leerLongSeguro();
        empleadoDao.eliminarEmpleado(id);
        System.out.println("Empleado eliminado exitosamente.");
    }

    private void listarEmpleadosConCargo() {
        List<Empleado> empleados = empleadoDao.listarEmpleados();
        if (empleados == null || empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
            return;
        }
        System.out.println("\n--- EMPLEADOS Y SUS CARGOS ---");
        empleados.forEach(e ->
                System.out.printf("Empleado: %s | Cargo: %s | Salario: %.2f%n",
                        e.getNombre(),
                        e.getCargo().getNombreCargo(),
                        e.getSalario()));
    }


    // ----------------- VALIDACIONES -----------------

    private int leerEnteroSeguro() {
        while (true) {
            try {
                int valor = Integer.parseInt(sc.nextLine().trim());
                return valor;
            } catch (NumberFormatException e) {
                System.out.print("Ingrese un número válido: ");
            }
        }
    }

    private Long leerLongSeguro() {
        while (true) {
            try {
                return Long.parseLong(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Ingrese un ID numérico válido: ");
            }
        }
    }

    private Double leerDoubleSeguro() {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine().trim().replace(",", "."));
            } catch (NumberFormatException e) {
                System.out.print("Ingrese un número decimal válido: ");
            }
        }
    }

    // ----------------- MAIN -----------------

    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        Menu menu = new Menu(em);
        menu.iniciar();
        em.close();
    }
}
