package run;

import config.JPAUtil;
import jakarta.persistence.EntityManager;

public class Main {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();








    }
}
