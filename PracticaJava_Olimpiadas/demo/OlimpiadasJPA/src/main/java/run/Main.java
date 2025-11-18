package run;

import entities.Producto;
import entities.ProductoDao;
import jakarta.persistence.EntityManager;

import java.awt.color.ProfileDataException;

public class Main {
    public static EntityManager em = JPAUtil.getEntityManager();

    public static ProductoDao productoDao = new ProductoDao(em);



    public static void main(String[] args) {
        Producto producto = new Producto( "Computadora", 399);

        Producto producto2 = new Producto("PC", 600);



        productoDao.guardar(producto);
        productoDao.guardar(producto2);
        System.out.println("LISTA: " + productoDao.obtenerTodos());
    }
}
