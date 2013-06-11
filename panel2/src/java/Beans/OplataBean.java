package Beans;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import entities.Mieszkanie;
import entities.Oplata;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Tomek
 */

public class OplataBean{

    private Oplata oplata;
    public String data;
    private int id_mieszkanie;

    /**
     * Creates a new instance of OplataBean
     */
    
    public OplataBean() {
        oplata = new Oplata();
    }   

    public int getId_mieszkanie() {
        return id_mieszkanie;
    }

    public void setId_mieszkanie(int id_mieszkanie) {
        this.id_mieszkanie = id_mieszkanie;
    }
  
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
        public Oplata getOplata() {
        return oplata;
    }
        
    public void setOplata(Oplata oplata){
        this.oplata = oplata;
    }
    
        private Mieszkanie findMiesz()
{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("panel2PU2");
        EntityManager em = emf.createEntityManager();
        Mieszkanie b =(Mieszkanie) em.createNamedQuery("Mieszkanie.findById").setParameter("id", id_mieszkanie).getSingleResult();
        em.close();
        return b;
}
    
    private java.sql.Date toSqlDate(String strDate)  {
        DateFormat dateFrm = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date myDate = new java.util.Date();
        java.sql.Date sqlDate;
        try
        {
          myDate = dateFrm.parse(strDate);
          sqlDate = new java.sql.Date(myDate.getTime());
        }
        catch (Exception e)
        {
          sqlDate = null;
        }

        return (sqlDate);
    }
    
    public String dodaj()
    {
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("panel2PU2");               
       EntityManager em = emf.createEntityManager();
       Mieszkanie a=findMiesz();     
       try
       {
       em.getTransaction().begin();
       oplata.setId(null);
       oplata.setData(toSqlDate(data));
       oplata.setMieszkanieID(a);
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
