package repository.dao;

import entities.Empleado;
import jakarta.persistence.EntityManager;
import org.hibernate.annotations.SQLDeletes;
import repository.ICargo;
import repository.IEmpleado;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class EmpleadoDao implements IEmpleado {
    private final EntityManager em;

    public EmpleadoDao(EntityManager em) {
        this.em = em;
    }

    @Override
    public Empleado guardarEmpleado(Empleado empleado){

        if (empleado.getId() == null) {
            em.getTransaction().begin(); // Iniciar una nueva transacción TODO: INVESTIGAR GET TRANSACTION
            em.persist(empleado); // Persistir la nueva carrera en la base de datos TODO: INVESTIGAR PERSIST
            em.getTransaction().commit(); // Confirmar la transacción TODO: INVESTIGAR COMMIT
            return empleado;
        }
        return em.merge(empleado); // Actualizar una carrera existente TODO: INVESTIGAR MERGE
    }

    @Override
    public List<Empleado> listarEmpleados(){

        List<Empleado> lista = em.createQuery("from Empleado", Empleado.class).getResultList(); // Consulta para obtener todas las carreras TODO: INVESTIGAR CREATEQUERY
        return (lista == null) ? Collections.emptyList() : lista;
    }

    @Override
    public void actualizarEmpleado(Empleado empleado){
        if (empleado == null || empleado.getId() == null) {
            throw new IllegalArgumentException("Empleado e ID son obligatorios para actualizar.");
        }
        em.getTransaction().begin();
        em.merge(empleado);  // JPA decide UPDATE por tener id != null.
        em.getTransaction().commit();
    }


    @Override
    public void eliminarEmpleado(Long idEmpleado) {
        Empleado empleado = em.find(Empleado.class, idEmpleado); // Consulta para encontrar la carrera por su ID
        try {
            if (empleado != null) {
                em.getTransaction().begin(); //TODO: INVESTIGAR GET TRANSACTION
                em.remove(empleado); // Elimina la carrera encontrada
                em.getTransaction().commit(); // Confirma la transacción
            }
        }catch (jakarta.persistence.NoResultException exception){
            System.out.println("No se encontro la carrera, consulta invalida.");
            System.out.print("ERROR: ");
            throw new RuntimeException(exception);
        }
    }

    @Override
    public Empleado buscarEmpleadoPorId(Long idEmpleado) {
        Empleado empleado = em.find(Empleado.class, idEmpleado);
        return empleado;
    }




}
