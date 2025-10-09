package viewModel;

import entities.Carrera;
import entities.Estudiante;
import jakarta.persistence.EntityManager;
import repository.dao.CarreraDao;
import repository.dao.EstudianteDao;

import java.util.List;
import java.util.Scanner;

public class Menu {

    private final EstudianteDao estudiante;
    private final CarreraDao carrera;

    // Inyectar el EntityManager requerido por los DAO
    public Menu(EntityManager em) {
        this.estudiante = new EstudianteDao(em);
        this.carrera = new CarreraDao(em);
    };


    public void menu() {
        Scanner sc = new Scanner(System.in);

        int opcion = 0;


        do {
            System.out.println("---Gestion de carreras y estudiantes---");
            System.out.println("1. Listar Estudiantes - Carrera");
            System.out.println("2. Menu de Estudiantes");
            System.out.println("3. Menu Carreras");
            System.out.println("4. Salir");

            opcion = sc.nextInt();

            switch (opcion){
               case 1:
                   List<Estudiante> listaEstudiantes = estudiante.listarEstudiantes();
                   if (listaEstudiantes.isEmpty()) {
                       System.out.println("No hay estudiantes registrados.");
                       return;
                   }
                   for (Estudiante estudiante : listaEstudiantes) {
                       System.out.printf("Estudiante: %s %s - Carrera: %s%n", estudiante.getNombres(), estudiante.getApellidos(), estudiante.getCarrera().getNombre());
                   }
                     break;
                case 2:
                    menuEstudiante();
                    break;
                case 3:
                    menuCarreras();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida, intente de nuevo.");
                    break;

            }
        }while(opcion!=4);
    }

    public void menuCarreras() {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;


        do {
            System.out.println("---Gestion de carreras---");
            System.out.println("1. Listar Carreras");
            System.out.println("2. Agregar Carrera");
            System.out.println("3. Actualizar Carrera");
            System.out.println("4. Eliminar Carrera");
            System.out.printf("5. Salir");
            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    List<Carrera> listaCarreras = carrera.listarCarreras();
                    if (listaCarreras.isEmpty()) {
                        System.out.println("No hay carreras registradas.");
                        return;
                    }
                    for (Carrera carrera : listaCarreras) {
                        System.out.printf("Carrera: %s", carrera.getNombre());
                    }
                    break;
                case 2:
                    System.out.println("------ Agregar Carrera ------");
                    System.out.println("Ingrese el nombre de la carrera:");
                    String nombreCarrera = sc.nextLine().trim();

                    while (nombreCarrera.isEmpty()) {
                        System.out.println("El nombre no puede estar vacio. Ingrese el nombre de la carrera:");
                        nombreCarrera = sc.nextLine().trim();
                    }

                    System.out.println("Ingrese el precio de la carrera:");
                    float precioCarrera;
                    while (true) {
                        String precioStr = sc.nextLine().trim().replace(',', '.');
                        try {
                            precioCarrera = Float.parseFloat(precioStr);
                            break;
                        } catch (NumberFormatException ex) {
                            System.out.println("Precio invalido. Ingrese un numero (ej. 1500 o 1500.50):");
                        }
                    }


                    Carrera nuevaCarrera = new Carrera(nombreCarrera, precioCarrera);
                    try {
                        carrera.guardarCarrera(nuevaCarrera);
                    } catch (Exception e) {
                        System.out.println("Error al guardar la carrera: " + e.getMessage());
                        return;
                    }
                    System.out.println("Carrera agregada exitosamente.");
                    break;
                case 3:
                    System.out.println("Actualizar Carrera - Funcion no implementada aun.");
                    break;
                case 4:
                    System.out.println("--- Eliminar Carrera ---");
                    List<Carrera> carreras = carrera.listarCarreras();
                    if (carreras.isEmpty()) {
                        System.out.println("No hay carreras registradas.");
                        return;
                    }
                    System.out.println("Ingrese el ID de la carrera a eliminar: ");
                    Long idCarrera = sc.nextLong();
                    carrera.eliminarCarrera(idCarrera);
                    System.out.println("Carrera eliminada exitosamente.");
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida, intente de nuevo.");
                    break;
            }
        } while (opcion != 5);

    }

    public void menuEstudiante() {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("---Gestion de estudiantes---");
            System.out.println("1. Listar Estudiantes");
            System.out.println("2. Agregar Estudiante");
            System.out.println("3. Actualizar Estudiante");
            System.out.println("4. Eliminar Estudiante");
            System.out.println("5. Salir");

            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    List<Estudiante> listaEstudiantes = estudiante.listarEstudiantes();
                    if (listaEstudiantes.isEmpty()) {
                        System.out.println("No hay estudiantes registrados.");
                        return;
                    }
                    for (Estudiante estudiante : listaEstudiantes) {
                        System.out.printf("Estudiante: %s %s - Carrera: %s%n", estudiante.getNombres(), estudiante.getApellidos(), estudiante.getCarrera().getNombre());
                    }
                    break;
                case 2:
                    System.out.println("------ Agregar Estudiante ------");
                    System.out.println("Ingrese los datos del estudiante:");
                    //Solicitar datos del estudiante
                    System.out.print("CIF: ");
                    String cif = sc.nextLine().trim();
                    while (cif.isEmpty()) {
                        System.out.println("El cif no puede estar vacio. Ingrese el cif del estudiante:");
                        cif = sc.nextLine().trim();
                    }

                    System.out.println("Nombres: ");
                    String nombres = sc.nextLine().trim();
                    while (nombres.isEmpty()) {
                        System.out.println("Los nombres no pueden estar vacios. Ingrese el cif del estudiante:");
                        nombres = sc.nextLine().trim();
                    }

                    System.out.println("Apellidos: ");
                    String apellidos = sc.nextLine().trim();
                    while (apellidos.isEmpty()) {
                        System.out.println("Los apellidos no pueden estar vacios. Ingrese los apellidos del estudiante:");
                        apellidos = sc.nextLine().trim();
                    }
                    System.out.println("Edad: ");
                    int edad = sc.nextInt();
                    while (edad < 0 ) {
                        System.out.println("La edad no puede ser negativa. Ingrese la edad del estudiante:");
                        edad = sc.nextInt();
                    }

                    //Seleccionar carrera
                    Carrera carreraEncontrada = seleccionarCarrera();

                    if (carreraEncontrada == null) {
                        System.out.println("Carrera no encontrada. No se puede agregar el estudiante.");
                        return;
                    }
                   Estudiante nuevoEstudiante = new Estudiante(cif, nombres, apellidos, carreraEncontrada);
                   estudiante.guardarEstudiante(nuevoEstudiante);
                   System.out.println("Estudiante agregado exitosamente.");
                   break;
                case 3:
                    System.out.println("Actualizar Estudiante - Funcion no implementada aun.");
                    break;
                case 4:
                    System.out.println("--- Eliminar Estudiante ---");
                    List<Estudiante> estudiantes = estudiante.listarEstudiantes();
                    if (estudiantes.isEmpty()) {
                        System.out.println("No hay estudiantes registrados.");
                        return;
                    }
                    System.out.println("Ingrese el ID del estudiante a eliminar: ");
                    Long idEstudiante = sc.nextLong();

                    estudiante.eliminarEstudiante(idEstudiante);
                    System.out.println("Estudiante eliminado exitosamente.");
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida, intente de nuevo.");
                    break;


            }
        }while(opcion!=5);
    }

    public Carrera seleccionarCarrera(){
        Scanner sc = new Scanner(System.in);

        List<Carrera> listaCarreras = carrera.listarCarreras();

        if (listaCarreras.isEmpty()) {
            System.out.println("No hay carreras registradas.");
            return null;
        }
        // Mostrar las carreras disponibles
        System.out.println("---Listado de Carreras---");
        System.out.println("ID --- Nombre");

        // Iterar y mostrar cada carrera
        for (Carrera carrera : listaCarreras) {
            System.out.println(carrera.getId() + " --- " + carrera.getNombre());
        }
        int cantidad_Carreras = listaCarreras.size();
        System.out.println("Total de carreras: " + cantidad_Carreras);

        // Solicitar al usuario que seleccione una carrera por ID
        System.out.print("Ingrese el ID de la carrera: ");
        Long idCarrera = sc.nextLong();

        // Buscar la carrera seleccionada por ID
        Carrera carreraSeleccionada = carrera.buscarCarreraPorId(idCarrera);
        if (carreraSeleccionada == null) {
            System.out.println("Carrera no encontrada.");
            return null;
        }
        return carreraSeleccionada;

    }






}
