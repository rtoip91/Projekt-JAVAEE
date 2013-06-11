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

    
    
    public String pobierz()
    {
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("PanelPU");
       
       
        mieszkaniec.setUprawnienieID(1);
        
        mieszkaniec.setNazwa("looooll");
        EntityManager em = emf.createEntityManager();
       
           em.getTransaction().begin();
        mieszkaniec.setId(null);
         em.persist(mieszkaniec);
         em.getTransaction().commit();
          em.close(); 
         return null;
      
        
    }
    
     
     
    public String dodaj()
    {
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("PanelPU");
       
       
        mieszkaniec.setUprawnienieID(1);
        
        mieszkaniec.setNazwa("looooll");
        EntityManager em = emf.createEntityManager();
       
           em.getTransaction().begin();
        mieszkaniec.setId(null);
         em.persist(mieszkaniec);
         em.getTransaction().commit();
          em.close(); 
         return null;
      
        
    }
    /**
     * Creates a new instance of MieszkaniecBean
     */
   
}
