/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;
import entities.Mieszkaniec;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Piotrek
 */
public class MieszkaniecBean {

  
    private Mieszkaniec mieszkaniec;

     public MieszkaniecBean() {
         mieszkaniec = new Mieszkaniec();
    }
    
    
    public Mieszkaniec getMieszkaniec() {
        return mieszkaniec;
    }

    
    public void setMieszkaniec(Mieszkaniec mieszkaniec) {
        this.mieszkaniec = mieszkaniec;
    }

    
    
     
     
    public String dodaj()
    {
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("panel2PU");
       
        mieszkaniec.setUprawnienieID(1);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
         em.persist(mieszkaniec);
         em.getTransaction().commit();
         return "sukces";
        
    }
    /**
     * Creates a new instance of MieszkaniecBean
     */
   
}
