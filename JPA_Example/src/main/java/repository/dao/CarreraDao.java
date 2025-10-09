package repository.dao;

import entities.Carrera;
import jakarta.persistence.EntityManager;
import org.hibernate.annotations.SQLDeletes;
import repository.ICarrera;

import java.sql.SQLException;
import java.util.List;


//Clase que implementa la interfaz ICarrera para manejar operaciones CRUD de la entidad Carrera
public class CarreraDao implements ICarrera {
    private final EntityManager em;

    public CarreraDao(EntityManager em) {
        this.em = em;
    }

    @Override
    public Carrera guardarCarrera(Carrera carrera) {
        if (carrera.getId() == null) {
            em.getTransaction().begin(); // Iniciar una nueva transacción TODO: INVESTIGAR GET TRANSACTION
            em.persist(carrera); // Persistir la nueva carrera en la base de datos TODO: INVESTIGAR PERSIST
            em.getTransaction().commit(); // Confirmar la transacción TODO: INVESTIGAR COMMIT
            return carrera;
        }
        return em.merge(carrera); // Actualizar una carrera existente TODO: INVESTIGAR MERGE
    }

    @Override
    public List<Carrera> listarCarreras() {
        List<Carrera> lista = em.createQuery("from Carrera", Carrera.class).getResultList(); // Consulta para obtener todas las carreras TODO: INVESTIGAR CREATEQUERY
        return lista;
    }

    @Override
    public void actualizarCarrera(Long idCarrera) {

    }

    @Override
    public void eliminarCarrera(Long id) {
        Carrera carrera = em.find(Carrera.class, id); // Consulta para encontrar la carrera por su ID
        try {
            if (carrera != null) {
                em.getTransaction().begin(); //TODO: INVESTIGAR GET TRANSACTION
                em.remove(carrera); // Elimina la carrera encontrada
                em.getTransaction().commit(); // Confirma la transacción
            }
        }catch (jakarta.persistence.NoResultException exception){
            System.out.println("No se encontro la carrera, consulta invalida.");
            System.out.print("ERROR: ");
            throw new RuntimeException(exception);
        }
    }
    @Override
    public Carrera buscarCarreraPorId(Long idCarrera) {
        Carrera carrera = em.find(Carrera.class, idCarrera);
        return carrera;
    }




}
