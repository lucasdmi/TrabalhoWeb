/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.iff.edu.javaweb20181.trabalhoweb.dao;

import br.iff.edu.javaweb20181.trabalhoweb.model.Celular;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author 16322064711
 */
public class CelularDAO {
    
    public boolean insert(Celular ce) {
        EntityManager em = ManagerFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(ce);
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return false;
    }
    
     public boolean update(Celular ce) {
        EntityManager em = ManagerFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(ce);
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return false;
    }
     
     public boolean delete(long id) {
        EntityManager em = ManagerFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            Celular ce = em.find(Celular.class, id);
            em.remove(ce);
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            System.out.println("EX: " + ex.getMessage());
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return false;
    }
     
     public Celular findById(long id) {
        EntityManager em = ManagerFactory.getEntityManager();
        try {
            Celular ce = em.find(Celular.class, id);
            return ce;
        } catch (Exception ex) {
            System.out.println("****" + ex.getMessage());
        } finally {
            em.close();
        }
        return null;
    }
     
      public List<Celular> findAll() {
        
        EntityManager em = ManagerFactory.getEntityManager();
        List<Celular> list = new ArrayList<>();
        try {
            Query q = em.createQuery("SELECT c FROM Celular c");
            list.addAll(q.getResultList());
            return list;
        } catch (Exception ex) {

        } finally {
            em.close();
        }
        return list;
    }
}
