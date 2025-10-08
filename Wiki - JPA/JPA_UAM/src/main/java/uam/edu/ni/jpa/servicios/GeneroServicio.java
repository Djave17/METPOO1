package uam.edu.ni.jpa.servicios;

import jakarta.persistence.EntityManager;
import uam.edu.ni.jpa.entity.Genero;
import uam.edu.ni.jpa.util.JpaUtil;

import java.sql.SQLDataException;
import java.sql.SQLException;

public class GeneroServicio {
    public Genero obtenerOGuardar(String nombre){
        EntityManager em = JpaUtil.em();
        try {
            Genero g = em.createQuery(
                            "select g from Genero g where lower(g.nombre) = lower(:n)", Genero.class)
                    .setParameter("n", nombre)
                    .setMaxResults(1)
                    .getResultList()
                    .stream()
                    .findFirst()
                    .orElse(null);

            if (g != null) return g;

            em.getTransaction().begin();
            g = new Genero(nombre);
            em.persist(g);
            em.getTransaction().commit();
            return g;
        } finally {
            em.close();
        }
    }
}
