/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;
import entities.Administrator;
import entities.Mieszkaniec;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
/**
 *
 * @author Piotrek
 */
public class LoginBean {

    private Mieszkaniec mieszkaniec =null;
    private Administrator administrator =null;
    
    private String login;
    private String haslo;

        private String rezultat;

    public String getRezultat() {
        return rezultat;
    }

    public void setRezultat(String rezultat) {
        this.rezultat = rezultat;
    }
    public Mieszkaniec getMieszkaniec() {
        return mieszkaniec;
    }

    public void setMieszkaniec(Mieszkaniec mieszkaniec) {
        this.mieszkaniec = mieszkaniec;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }
    
    public String logowanie ()
    {
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("panel2PU2");
        EntityManager em = factory.createEntityManager();
         Query q = em.createQuery("SELECT u FROM Mieszkaniec u WHERE u.login = :login AND u.haslo= :password");
        q.setParameter("login", login);
        q.setParameter("password", haslo);
         Query w = em.createQuery("SELECT u FROM Administrator u WHERE u.login = :login AND u.haslo= :password");
         q.setParameter("login", login);
        q.setParameter("password", haslo);
        try{
            mieszkaniec = (Mieszkaniec) q.getSingleResult();
            rezultat="Mieszkaniec";
            administrator=null;
        }
        catch (Exception e)
                {
                    rezultat="Fail";
                }
        if(rezultat.equals("Fail"))
        {
             try{
            administrator = (Administrator) w.getSingleResult();
            rezultat="Admin";
            mieszkaniec=null;
             }
             catch (Exception e)
             {
                 rezultat="Fail";
             }
        }
        em.close();
         return rezultat;
        }
        
        
    
    /**
     * 
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }
}
