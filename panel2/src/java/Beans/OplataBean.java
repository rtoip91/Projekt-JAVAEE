package Beans;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;
import entities.Oplata;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    /**
     * Creates a new instance of OplataBean
     */
    public OplataBean() {
        oplata = new Oplata();
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
    
    public List<Oplata> getLista(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PanelPU");     
        EntityManager em = emf.createEntityManager();
        List list = em.createNamedQuery("Oplata.findAll").getResultList();
        em.close();
        return list;
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
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("PanelPU");
              
       oplata.setData(toSqlDate(data));
       
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
