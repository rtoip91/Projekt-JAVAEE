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

  
    private Mieszkaniec mieszkaniec = new Mieszkaniec();

    public Mieszkaniec getMieszkaniec() {
        return mieszkaniec;
    }

    
    public void setMieszkaniec(Mieszkaniec mieszkaniec) {
        this.mieszkaniec = mieszkaniec;
    }

    public static void setEmf(EntityManagerFactory emf) {
        MieszkaniecBean.emf = emf;
    }

    public static EntityManagerFactory getEmf() {
        return emf;
    }
    
     private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jeju");
     
    public String dodaj (Mieszkaniec a)
    {
        this.mieszkaniec=a;
        mieszkaniec.setUprawnienieID(1);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try
        {
         em.persist(mieszkaniec);
         em.getTransaction().commit();
         return null;
        }
        catch (Exception e)
           {
                    return "Nie powiodło się";
            }
    }
    /**
     * Creates a new instance of MieszkaniecBean
     */
    public MieszkaniecBean() {
    }
}
