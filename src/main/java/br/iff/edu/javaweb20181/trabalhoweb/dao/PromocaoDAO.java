/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.iff.edu.javaweb20181.trabalhoweb.dao;

import br.iff.edu.javaweb20181.trabalhoweb.model.Celular;
import br.iff.edu.javaweb20181.trabalhoweb.model.Promocao;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author 16322064711
 */
public class PromocaoDAO {
    
    public boolean insert(Promocao p) {
        EntityManager em = ManagerFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return false;
    }
    
     public boolean update(Promocao p) {
        EntityManager em = ManagerFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(p);
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
            Promocao p = em.find(Promocao.class, id);
            em.remove(p);
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
     
     public Promocao findById(long id) {
        EntityManager em = ManagerFactory.getEntityManager();
        try {
            Promocao p = em.find(Promocao.class, id);
            return p;
        } catch (Exception ex) {
            System.out.println("****" + ex.getMessage());
        } finally {
            em.close();
        }
        return null;
    }
     
      public List<Promocao> findAll() {
        EntityManager em = ManagerFactory.getEntityManager();
        List<Promocao> list = new ArrayList<>();
        try {
            Query q = em.createQuery("SELECT  FROM Promocao");
            list.addAll(q.getResultList());
            return list;
        } catch (Exception ex) {

        } finally {
            em.close();
        }
        return list;
    }
}
