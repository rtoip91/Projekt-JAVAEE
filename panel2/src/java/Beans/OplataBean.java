package Beans;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import entities.Oplata;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Tomek
 */

public class OplataBean{

    private Oplata oplata;

    /**
     * Creates a new instance of OplataBean
     */
    public OplataBean() {
        oplata = new Oplata();
    }   
    
        public Oplata getOplata() {
        return oplata;
    }
        
    public void setOplata(Oplata oplata){
        this.oplata = oplata;
    }    
    
    public String dodaj()
    {
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("PanelPU");
       
       EntityManager em = emf.createEntityManager();
       
       em.getTransaction().begin();
       try
       {
       oplata.setId(null);
       em.persist(oplata);
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
