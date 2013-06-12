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
public class NowaSprawaBean {

    /**
     * Creates a new instance of NowaSprawaBean
     */
    private Sprawa nowasprawa;
    public NowaSprawaBean() {
    }
    
        public void setNowaSprawaBean(Sprawa nowasprawa) {
        this.nowasprawa = nowasprawa;
    }
         
}
