package uam.edu.ni.jpa.vistas;


import uam.edu.ni.jpa.entity.Genero;
import uam.edu.ni.jpa.entity.Pelicula;
import uam.edu.ni.jpa.servicios.GeneroServicio;
import uam.edu.ni.jpa.servicios.PeliculaServicio;
import uam.edu.ni.jpa.util.ConsoleIO;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class PeliculaConsola {
    ConsoleIO io = new ConsoleIO();
    private final PeliculaServicio ps = new PeliculaServicio();
    private final GeneroServicio gs = new GeneroServicio();
    private final Scanner sc = new Scanner(System.in);

    public void menu(){
        int op;
        do{
            System.out.println("\n🎬 Películas");
            System.out.println("1) Agregar  2) Listar  3) Actualizar rating  4) Eliminar  5) Salir");
            System.out.print("Opción: ");
            op = sc.nextInt();
            sc.nextLine(); // <--- consumir el salto de línea pendiente
            switch(op){
                case 1 -> agregar();
                case 2 -> listar();
                case 3 -> actualizar();
                case 4 -> eliminar();
            }
        } while(op != 5);
    }

    // ... existing code ...
    private void agregar(){


        String titulo   = io.readLine("Título: ");
        String director = io.readLine("Director: ");
        var fecha       = io.readDate("Fecha estreno (yyyy-mm-dd): ");
        double rating   = io.readDouble("Rating (0-10): ");
        String generoNombre = io.readLine("Género: ");

        GeneroServicio gs = new GeneroServicio();
        Genero genero = gs.obtenerOGuardar(generoNombre);

        Long id = ps.crear(titulo, director, fecha, rating, genero);
        System.out.println(" Creado con id " + id);
    }

    private void listar(){
        List<Pelicula> ls = ps.listar();
        ls.forEach(p -> System.out.printf("%d | %s | %s | %s | ⭐%.1f | [%s]%n",
                p.getId(), p.getTitulo(), p.getDirector(), p.getFechaEstreno(), p.getRating(), p.getGenero().getNombre()));
    }
    private void actualizar(){
        System.out.print("ID: "); Long id = Long.parseLong(sc.nextLine());
        System.out.print("Nuevo rating: "); double r = Double.parseDouble(sc.nextLine());
        ps.actualizarRating(id, r); System.out.println("✅ Actualizado.");
    }
    private void eliminar(){
        System.out.print("ID: "); 
        String line = sc.nextLine();
        // Reintentar si está vacío o no es numérico
        while (line == null || line.trim().isEmpty()) {
            System.out.print("ID: ");
            line = sc.nextLine();
        }
        Long id;
        try {
            id = Long.parseLong(line.trim());
        } catch (NumberFormatException e) {
            System.out.println("ID inválido. Debe ser un número entero.");
            return;
        }
        ps.eliminar(id); 
        System.out.println("🗑️ Eliminado.");
    }
}
