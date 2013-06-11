/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Piotrek
 */
@Entity
@Table(name = "Uprawnienie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Uprawnienie.findAll", query = "SELECT u FROM Uprawnienie u"),
    @NamedQuery(name = "Uprawnienie.findByUprID", query = "SELECT u FROM Uprawnienie u WHERE u.uprID = :uprID"),
    @NamedQuery(name = "Uprawnienie.findByNazwa", query = "SELECT u FROM Uprawnienie u WHERE u.nazwa = :nazwa")})
public class Uprawnienie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "uprID", nullable = false)
    private Integer uprID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Nazwa", nullable = false, length = 30)
    private String nazwa;

    public Uprawnienie() {
    }

    public Uprawnienie(Integer uprID) {
        this.uprID = uprID;
    }

    public Uprawnienie(Integer uprID, String nazwa) {
        this.uprID = uprID;
        this.nazwa = nazwa;
    }

    public Integer getUprID() {
        return uprID;
    }

    public void setUprID(Integer uprID) {
        this.uprID = uprID;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uprID != null ? uprID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Uprawnienie)) {
            return false;
        }
        Uprawnienie other = (Uprawnienie) object;
        if ((this.uprID == null && other.uprID != null) || (this.uprID != null && !this.uprID.equals(other.uprID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Uprawnienie[ uprID=" + uprID + " ]";
    }
    
}
