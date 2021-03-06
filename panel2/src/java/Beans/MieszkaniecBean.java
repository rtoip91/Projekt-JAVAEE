/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;
import entities.Budynek;
import entities.Mieszkaniec;
import java.util.List;
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

    
    public List<Mieszkaniec> getLista()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("panel2PU2");
        EntityManager em = emf.createEntityManager();
        List lista = em.createNamedQuery("Mieszkaniec.findAll").getResultList();
        em.close();
        return lista;
        
    }
     
     
    public String dodaj()
    {
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("panel2PU2");
       
       
        mieszkaniec.setUprawnienieID(1);
        
        mieszkaniec.setNazwa(mieszkaniec.toString());
        EntityManager em = emf.createEntityManager();
       
           em.getTransaction().begin();
           try
           {
        mieszkaniec.setId(null);
         em.persist(mieszkaniec);
         em.getTransaction().commit();
          em.close(); 
           }
           catch (Exception e)
             {
                   em.close();   
             }
         return null;
      
        
    }
    /**
     * Creates a new instance of MieszkaniecBean
     */
   
}
