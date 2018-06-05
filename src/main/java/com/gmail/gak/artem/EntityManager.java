package com.gmail.gak.artem;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManager {
    private javax.persistence.EntityManager em;
    private static EntityManager ourInstance = new EntityManager();

    public static EntityManager getInstance() {
        return ourInstance;
    }

    private EntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPATest");
        em = emf.createEntityManager();
    }

    public javax.persistence.EntityManager getEm() {
        return em;
    }

    public void setEm(javax.persistence.EntityManager em) {
        this.em = em;
    }

    public static EntityManager getOurInstance() {
        return ourInstance;
    }

    public static void setOurInstance(EntityManager ourInstance) {
        EntityManager.ourInstance = ourInstance;
    }
}
