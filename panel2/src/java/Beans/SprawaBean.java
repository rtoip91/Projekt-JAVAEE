/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;
import entities.Sprawa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author janek
 */
public class SprawaBean {

    /**
     * Creates a new instance of SprawaBean
     */
    public SprawaBean() {
    }
    
            public List<Sprawa> getLista()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("panel2PU2");
        EntityManager em = emf.createEntityManager();
        List lista = em.createNamedQuery("Sprawa.findAll").getResultList();
        em.close();
        return lista;
        
    }
}
