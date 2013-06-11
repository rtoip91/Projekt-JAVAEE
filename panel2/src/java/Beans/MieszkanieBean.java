/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;
import entities.Mieszkanie;
import entities.Budynek;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author Piotrek
 */
public class MieszkanieBean {

    private Mieszkanie mieszkanie; 
    private int id_budynek;
    private int id_user;

    public int getId_budynek() {
        return id_budynek;
    }

    public void setId_budynek(int id_budynek) {
        this.id_budynek = id_budynek;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
    
    
    public MieszkanieBean() {
        mieszkanie = new Mieszkanie();
    }
    
    public List<Mieszkanie> getLista()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PanelPU");
        EntityManager em = emf.createEntityManager();
        List lista = em.createNamedQuery("Mieszkanie.findAll").getResultList();
        em.close();
        return lista;
        
    }
    public String dodaj ()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PanelPU");
        EntityManager em = emf.createEntityManager();
        
         em.getTransaction().begin();
         mieszkanie.setId(null);
         em.persist(mieszkanie);
         em.getTransaction().commit();
         em.close(); 
         return null;
    }
}
