package run;

import config.JPAUtil;
import jakarta.persistence.EntityManager;
import viewModel.Menu;

public class Main {

    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        Menu menu = new Menu(em);
        menu.iniciar();
        em.close();
    }
}
