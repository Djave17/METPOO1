package uam.edu.ni.jpa.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
    //TODO: porque se crea una nueva instancia de EntityManagerFactor. Investigar EntityManagerFactory.class
    // Inicialización perezosa y segura del EMF para exponer bien la causa raíz si falla.
    private static volatile EntityManagerFactory emf;

    public static EntityManager em() {
        return getEmf().createEntityManager();
    }

    private static EntityManagerFactory getEmf() {
        if (emf == null) {
            synchronized (JpaUtil.class) {
                if (emf == null) {
                    try {
                        emf = Persistence.createEntityManagerFactory("wiki_jpa"); // mismo nombre que tu persistence.xml
                    } catch (Throwable t) {
                        // Desenrollar para obtener la causa raíz y dar un mensaje claro
                        Throwable root = t;
                        while (root.getCause() != null) root = root.getCause();
                        throw new IllegalStateException(
                                "Error inicializando JPA (revisa persistence.xml, conexión a BD y driver JDBC). Causa raíz: "
                                        + root.getClass().getName() + ": " + root.getMessage(), t);
                    }
                    // Cerrar el EMF al apagar la JVM
                    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                        try {
                            if (emf != null && emf.isOpen()) {
                                emf.close();
                            }
                        } catch (Exception ignore) {}
                    }));
                }
            }
        }
        return emf;
    }
}
