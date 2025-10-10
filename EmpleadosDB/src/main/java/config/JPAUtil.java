package config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JPAUtil {
    private static final String PERSISTENCE_UNIT_NAME = "uam"; // Asegúrate de que coincida con persistence.xml
    private static final Logger LOGGER = Logger.getLogger(JPAUtil.class.getName());

    private static final EntityManagerFactory emf = createEntityManagerFactory();

    private static EntityManagerFactory createEntityManagerFactory() {
        try {
            // Intenta crear la factoría de EM usando la unidad de persistencia
            return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        } catch (Exception e) {
            // Mensaje claro y manejo seguro
            LOGGER.log(Level.SEVERE, "Error al inicializar EntityManagerFactory para la unidad de persistencia '" 
                    + PERSISTENCE_UNIT_NAME + "'. Ver persistencia.xml y dependencias. Causa: ", e);
            // Propaga un error explícito para evitar un NullPointer posterior
            throw new ExceptionInInitializerError("Fallo al inicializar EntityManagerFactory: " + e.getMessage());
        }
    }

    public static EntityManager getEntityManager() {
        if (emf == null) {
            throw new IllegalStateException("EntityManagerFactory no ha sido inicializado correctamente.");
        }
        return emf.createEntityManager();
    }

    private JPAUtil() {
        // evitar instanciación
    }
}


