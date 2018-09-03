/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.iff.edu.javaweb20181.trabalhoweb.dao;

import br.iff.edu.javaweb20181.trabalhoweb.model.Celular;
import br.iff.edu.javaweb20181.trabalhoweb.model.Contato;
import javax.persistence.EntityManager;

/**
 *
 * @author 16322064711
 */
public class ContatoDAO {
    public boolean insert(Contato c) {
        EntityManager em = ManagerFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return false;
    }
}
