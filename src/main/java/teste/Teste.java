/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import br.iff.edu.javaweb20181.trabalhoweb.dao.ContatoDAO;
import br.iff.edu.javaweb20181.trabalhoweb.dao.ManagerFactory;
import br.iff.edu.javaweb20181.trabalhoweb.model.Contato;
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
       // EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoWEB");
      //  EntityManager em = emf.createEntityManager();
       // EntityManager em = ManagerFactory.getEntityManager();
        ContatoDAO  cDAO = new ContatoDAO();

        Contato ce = new Contato();
        ce.setEmail("meuemail");
        ce.setNome("Lucas");
        ce.setMens("ola q passa");
        cDAO.insert(ce);
        
       // em.getTransaction().begin();
       // em.persist(ce);
       // em.getTransaction().commit();
       // em.close();
    }
    
}
