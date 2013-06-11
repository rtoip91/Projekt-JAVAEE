package Beans;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

<<<<<<< HEAD
//import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;
=======
import entities.Mieszkaniec;
>>>>>>> 842f2e66c1e5910b2b6201ef01eeca689e437be3
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
    private Mieszkaniec id_mieszkaniec;

    /**
     * Creates a new instance of OplataBean
     */
    public List<Mieszkaniec> getLista(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PanelPU");     
        EntityManager em = emf.createEntityManager();
        List lista = em.createNamedQuery("Mieszkaniec.findAll").getResultList();
        em.close();
        return lista;
    }
    
    public OplataBean() {
        oplata = new Oplata();
    }   

    public Mieszkaniec getId_mieszkaniec() {
        return id_mieszkaniec;
    }

    public void setId_mieszkaniec(Mieszkaniec id_mieszkaniec) {
        this.id_mieszkaniec = id_mieszkaniec;
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
    
<<<<<<< HEAD
    public List<Oplata> getLista(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("panel2PU2");     
        EntityManager em = emf.createEntityManager();
        List lista = em.createNamedQuery("Oplata.findAll").getResultList();
        em.close();
        return lista;
    }
    
=======
>>>>>>> 842f2e66c1e5910b2b6201ef01eeca689e437be3
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
