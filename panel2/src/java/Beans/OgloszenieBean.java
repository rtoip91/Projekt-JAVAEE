/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;


import entities.Budynek;
import entities.Ogloszenie;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author janek
 */
public class OgloszenieBean {

    private int id_budynek;
    private Ogloszenie ogloszenie;
    /**
     * Creates a new instance of OgloszenieBean
     */
    public int getId_budynek() {
        return id_budynek;
    }

    public void setId_budynek(int id_budynek) {
        this.id_budynek = id_budynek;
    }  

    public Ogloszenie getOgloszenie() {
        return ogloszenie;
    }

    public void setOgloszenie(Ogloszenie ogloszenie) {
        this.ogloszenie = ogloszenie;
    }
    
    public OgloszenieBean() {
        ogloszenie = new Ogloszenie();
    }
    
    public List<Ogloszenie> getLista()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("panel2PU2");
        EntityManager em = emf.createEntityManager();
        List lista = em.createNamedQuery("Ogloszenie.findAll").getResultList();
        em.close();
        return lista;      
    }
        
    private Budynek findBud()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("panel2PU2");
        EntityManager em = emf.createEntityManager();
        Budynek b =(Budynek) em.createNamedQuery("Budynek.findById").setParameter("id", id_budynek).getSingleResult();
        em.close();
        return b;
    } 
    
    public String dodaj ()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("panel2PU2");
        EntityManager em = emf.createEntityManager();
        Budynek b = findBud();
        try{
         em.getTransaction().begin();
         ogloszenie.setBudynekID(b);
         ogloszenie.setId(null);
         
         em.persist(ogloszenie);
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
