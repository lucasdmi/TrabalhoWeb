/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import br.iff.edu.javaweb20181.trabalhoweb.dao.CelularDAO;
import br.iff.edu.javaweb20181.trabalhoweb.dao.ContatoDAO;
import br.iff.edu.javaweb20181.trabalhoweb.dao.ManagerFactory;
import br.iff.edu.javaweb20181.trabalhoweb.model.Celular;
import br.iff.edu.javaweb20181.trabalhoweb.model.Contato;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 16322064711
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoWEB");
        EntityManager em = emf.createEntityManager();
      


       // em.getTransaction().begin();
       // em.persist(ce);
       // em.getTransaction().commit();
       // em.close();
    }
    
}
