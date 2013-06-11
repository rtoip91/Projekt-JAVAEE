/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;
import entities.Mieszkanie;
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
public class MieszkanieBean {

    private Mieszkanie mieszkanie; 
    private Budynek id_budynek;
    private Mieszkaniec id_user;

    public Mieszkanie getMieszkanie() {
        return mieszkanie;
    }

    public void setMieszkanie(Mieszkanie mieszkanie) {
        this.mieszkanie = mieszkanie;
    }

    public Budynek getId_budynek() {
        return id_budynek;
    }

    public void setId_budynek(Budynek id_budynek) {
        this.id_budynek = id_budynek;
    }

    public Mieszkaniec getId_user() {
        return id_user;
    }

    public void setId_user(Mieszkaniec id_user) {
        this.id_user = id_user;
    }

    
    
    
    public MieszkanieBean() {
        mieszkanie = new Mieszkanie();
    }
    
    public List<Mieszkanie> getLista()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("panel2PU");
        EntityManager em = emf.createEntityManager();
        List lista = em.createNamedQuery("Mieszkanie.findAll").getResultList();
        em.close();
        return lista;
        
    }
    public String dodaj ()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("panel2PU");
        EntityManager em = emf.createEntityManager();
        
         em.getTransaction().begin();
         mieszkanie.setMieszkaniecID(id_user);
         mieszkanie.setBudynekID(id_budynek);
         mieszkanie.setNazwa(id_budynek.getNazwa() + mieszkanie.getNrPosesji());
         mieszkanie.setId(null);
         try{
         em.persist(mieszkanie);
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
