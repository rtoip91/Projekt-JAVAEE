/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;
import entities.Budynek;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Piotrek
 */
public class BudynekBeans {

    Budynek budynek;

    public Budynek getBudynek() {
        return budynek;
    }

    public void setBudynek(Budynek budynek) {
        this.budynek = budynek;
    }
    /**
     * Creates a new instance of BudynekBeans
     */
    public BudynekBeans() {
        budynek = new Budynek();
        
       
    }
    
    public List<Budynek> getLista()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("panel2PU2");
        EntityManager em = emf.createEntityManager();
        List lista = em.createNamedQuery("Budynek.findAll").getResultList();
        em.close();
        return lista;
        
    }
    
    public String dodaj ()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("panel2PU2");
        EntityManager em = emf.createEntityManager();
        
        
         em.getTransaction().begin();
         try
         {
         budynek.setNazwa(budynek.toString());
         budynek.setId(null);
         em.persist(budynek);
         em.getTransaction().commit();
          em.close(); 
         }
         catch (Exception e)
             {
                   em.close();   
             }
         return null;
    }
}
