package repository.dao;

import entities.Carrera;
import entities.Estudiante;
import jakarta.persistence.EntityManager;
import repository.IEstudiante;

import java.util.List;

public class EstudianteDao implements IEstudiante {
    private final EntityManager em;

    public EstudianteDao(EntityManager em) {
        this.em = em;
    }

    @Override
    public Estudiante guardarEstudiante(Estudiante estudiante) {
        if(estudiante.getId()==null){
            em.getTransaction().begin();
            em.persist(estudiante);
            em.getTransaction().commit();
            return estudiante;
        }
        return em.merge(estudiante);
    }

    @Override
    public List<Estudiante> listarEstudiantes() {
        List<Estudiante> lista = em.createQuery("from Estudiante", Estudiante.class).getResultList();
        return lista;
    }


    @Override
    public void actualizarEstudiante(Long id){
        Estudiante estudiante = em.find(Estudiante.class, id);
        if(estudiante==null){
            em.getTransaction().begin();
            estudiante = em.merge(estudiante);
            em.getTransaction().commit();

        }

    }

    @Override
    public void eliminarEstudiante(Long id){
        Estudiante estudiante = em.find(Estudiante.class, id);
        if (estudiante!=null){
            em.getTransaction().begin();
            em.remove(estudiante);
            em.getTransaction().commit();
        }

    }


}
