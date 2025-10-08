package uam.edu.ni.jpa.servicios;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import uam.edu.ni.jpa.entity.Genero;
import uam.edu.ni.jpa.entity.Pelicula;
import uam.edu.ni.jpa.util.JpaUtil;

import java.time.LocalDate;
import java.util.List;
public class PeliculaServicio {

    public Long crear(String titulo, String director, LocalDate fechaEstreno, double rating, Genero genero){
        EntityManager em = JpaUtil.em();
        try{
            em.getTransaction().begin();
            Pelicula p = new Pelicula(titulo,director,fechaEstreno,rating,genero);
            em.persist(p);
            em.getTransaction().commit();
            return p.getId();
        }finally {
            em.close();
        }

    }
    public List<Pelicula> listar(){
        EntityManager em = JpaUtil.em();
        try{
            return em.createQuery("select p from Pelicula p order by p.titulo",Pelicula.class).getResultList();}
        catch (jakarta.persistence.NoResultException e){
            return null;
        }
    }

    public void actualizarRating(Long id, double nuevo){
        EntityManager em = JpaUtil.em();
        try {
            em.getTransaction().begin(); //TODO: INVESTIGAR GET TRANSACTION
            Pelicula p = em.find(Pelicula.class, id);
            if (p != null) p.setRating(nuevo);
            em.getTransaction().commit();

        }catch (jakarta.persistence.NoResultException e){
            throw new RuntimeException(e);
        }
    }

    public void eliminar(Long id){
        EntityManager em = JpaUtil.em();
        try {
            em.getTransaction().begin();
            Pelicula p = em.find(Pelicula.class, id);
            if (p != null) em.remove(p);
            em.getTransaction().commit();
        }catch (jakarta.persistence.NoResultException e){
            System.out.println("No se encontro la pelicula, consulta invalida.");
            System.out.print("ERROR: ");throw new RuntimeException(e);
        }
    }

}
