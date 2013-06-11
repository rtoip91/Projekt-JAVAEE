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
    private int id_budynek;
    private String login;

    public int getId_budynek() {
        return id_budynek;
    }

    public void setId_budynek(int id_budynek) {
        this.id_budynek = id_budynek;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Mieszkanie getMieszkanie() {
        return mieszkanie;
    }

    public void setMieszkanie(Mieszkanie mieszkanie) {
        this.mieszkanie = mieszkanie;
    }

    
private Budynek findBud()
{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("panel2PU2");
        EntityManager em = emf.createEntityManager();
        Budynek b =(Budynek) em.createNamedQuery("Budynek.findById").setParameter("id", id_budynek).getSingleResult();
        em.close();
        return b;
}      
    private Mieszkaniec findMiesz()
{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("panel2PU2");
        EntityManager em = emf.createEntityManager();
        Mieszkaniec b =(Mieszkaniec) em.createNamedQuery("Mieszkaniec.findByLogin").setParameter("login", login).getSingleResult();
        em.close();
        return b;
}
    
    
    public MieszkanieBean() {
        mieszkanie = new Mieszkanie();
    }
    
    public List<Mieszkanie> getLista()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("panel2PU2");
        EntityManager em = emf.createEntityManager();
        List lista = em.createNamedQuery("Mieszkanie.findAll").getResultList();
        em.close();
        return lista;
        
    }
    public String dodaj ()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("panel2PU2");
        EntityManager em = emf.createEntityManager();
        Mieszkaniec a=findMiesz();
        Budynek b = findBud();
        try{
         em.getTransaction().begin();
         mieszkanie.setMieszkaniecID(a);
         mieszkanie.setBudynekID(b);
         mieszkanie.setNazwa(b.getNazwa() + mieszkanie.getNrPosesji());
         mieszkanie.setId(null);
         
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
