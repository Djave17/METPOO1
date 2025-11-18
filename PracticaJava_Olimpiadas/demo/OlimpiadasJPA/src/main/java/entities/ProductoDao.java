package entities;

import jakarta.persistence.EntityManager;

import java.util.List;

public class ProductoDao {

    private EntityManager em;

    public ProductoDao(EntityManager em){
        this.em = em;
    }

    public void  guardar(Producto producto){
        em.getTransaction().begin();
        em.persist(producto);
        em.getTransaction().commit();

    }

    public List<Producto> obtenerTodos(){
        //ESO ESTA MALO PASALO
        return em.createQuery("SELECT p FROM Producto p", Producto.class)
                .getResultList();


    }


}
