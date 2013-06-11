/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;
import entities.Budynek;
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
    
    public String dodaj ()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PanelPU");
        EntityManager em = emf.createEntityManager();
        
         em.getTransaction().begin();
         budynek.setId(null);
         em.persist(budynek);
         em.getTransaction().commit();
          em.close(); 
         return null;
    }
}
