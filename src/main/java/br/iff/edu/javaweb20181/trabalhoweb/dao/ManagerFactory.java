package br.iff.edu.javaweb20181.trabalhoweb.dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class ManagerFactory {
    
    private static EntityManagerFactory emf;
    
    public static EntityManager getEntityManager(){
        if(emf == null){
            emf = Persistence.createEntityManagerFactory("TrabalhoWEB");
        }
        return emf.createEntityManager();
    }
}