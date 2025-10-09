package run;

import config.JPAUtil;
import entities.Carrera;
import jakarta.persistence.EntityManager;
import repository.dao.CarreraDao;
import viewModel.Menu;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();

        Menu menu = new Menu(em);
        menu.menu();






    }
}
