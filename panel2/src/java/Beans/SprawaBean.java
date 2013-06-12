/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;
import entities.Mieszkaniec;
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
    
    private String login;
    private Sprawa sprawa;

    /**
     * Creates a new instance of SprawaBean
     */
    public SprawaBean() {
        sprawa = new Sprawa();
    }

    public Sprawa getSprawa() {
        return sprawa;
    }

    public void setSprawa(Sprawa sprawa) {
        this.sprawa = sprawa;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }   
    public List<Sprawa> getLista()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("panel2PU2");
        EntityManager em = emf.createEntityManager();
        List lista = em.createNamedQuery("Sprawa.findAll").getResultList();
        em.close();
        return lista;  
    }
    private Mieszkaniec findMiesz()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("panel2PU2");
        EntityManager em = emf.createEntityManager();
        Mieszkaniec b =(Mieszkaniec) em.createNamedQuery("Mieszkaniec.findByLogin").setParameter("login", login).getSingleResult();
        em.close();
        return b;
    }
    public String dodaj ()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("panel2PU2");
        EntityManager em = emf.createEntityManager();
        Mieszkaniec a=findMiesz();
        try{
         
         sprawa.setMieszkaniecID(a);
         sprawa.setId(null);
         sprawa.setStatus("Do rozpatrzenia");
         em.getTransaction().begin();
         em.persist(sprawa);
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
