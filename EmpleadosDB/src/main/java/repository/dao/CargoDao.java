package repository.dao;

import entities.Cargo;
import jakarta.persistence.EntityManager;
import org.hibernate.annotations.SQLDeletes;
import repository.ICargo;

import java.sql.SQLException;
import java.util.List;

public class CargoDao implements ICargo {

    private final EntityManager em;

    public CargoDao(EntityManager em) {
        this.em = em;
    }

    @Override
    public Cargo guardarCargo(Cargo cargo) {
        if (cargo.getId() == null) {
            em.getTransaction().begin(); // Iniciar una nueva transacción TODO: INVESTIGAR GET TRANSACTION
            em.persist(cargo); // Persistir la nueva carrera en la base de datos TODO: INVESTIGAR PERSIST
            em.getTransaction().commit(); // Confirmar la transacción TODO: INVESTIGAR COMMIT
            return cargo;
        }
        return em.merge(cargo); // Actualizar una carrera existente TODO: INVESTIGAR MERGE
    }

    @Override
    public List<Cargo> listarCargos() {
        List<Cargo> lista = em.createQuery("from Cargo", Cargo.class).getResultList(); // Consulta para obtener todas las carreras TODO: INVESTIGAR CREATEQUERY
        return lista;
    }

    @Override
    public void actualizarCargo(Cargo cargo) {
        if (cargo.getId() != null) {
            em.getTransaction().begin(); // Iniciar una nueva transacción TODO: INVESTIGAR GET TRANSACTION
            em.merge(cargo); // Actualizar la carrera en la base de datos TODO: INVESTIGAR MERGE
            em.getTransaction().commit(); // Confirmar la transacción TODO: INVESTIGAR COMMIT
        }
        else {
            throw new IllegalArgumentException("El ID del cargo es obligatorio.");
        }

    }

    @Override
    public void eliminarCargo(Long idCargo) {
        Cargo cargo  = em.find(Cargo.class, idCargo); // Consulta para encontrar la carrera por su ID
        try {
            if (cargo != null) {
                em.getTransaction().begin(); //TODO: INVESTIGAR GET TRANSACTION
                em.remove(cargo); // Elimina la carrera encontrada
                em.getTransaction().commit(); // Confirma la transacción
            }
        }catch (jakarta.persistence.NoResultException exception){
            System.out.println("No se encontro la carrera, consulta invalida.");
            System.out.print("ERROR: ");
            throw new RuntimeException(exception);
        }
    }

    @Override
    public Cargo buscarCargoPorId(Long idCargo) {
        Cargo cargo = em.find(Cargo.class, idCargo);
        return cargo;
    }



}
