/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;


import entities.Ogloszenie;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author janek
 */
public class OgloszenieBean {

    /**
     * Creates a new instance of OgloszenieBean
     */
    public OgloszenieBean() {
    }
    
        public List<Ogloszenie> getLista()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("panel2PU2");
        EntityManager em = emf.createEntityManager();
        List lista = em.createNamedQuery("Ogloszenie.findAll").getResultList();
        em.close();
        return lista;
        
    }
}
