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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tomek
 */
@Entity
@Table(name = "Ogloszenie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ogloszenie.findAll", query = "SELECT o FROM Ogloszenie o"),
    @NamedQuery(name = "Ogloszenie.findById", query = "SELECT o FROM Ogloszenie o WHERE o.id = :id")})
public class Ogloszenie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "Tresc")
    private String tresc;
    @JoinColumn(name = "BudynekID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Budynek budynekID;

    public Ogloszenie() {
    }

    public Ogloszenie(Integer id) {
        this.id = id;
    }

    public Ogloszenie(Integer id, String tresc) {
        this.id = id;
        this.tresc = tresc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    public Budynek getBudynekID() {
        return budynekID;
    }

    public void setBudynekID(Budynek budynekID) {
        this.budynekID = budynekID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ogloszenie)) {
            return false;
        }
        Ogloszenie other = (Ogloszenie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Ogloszenie[ id=" + id + " ]";
    }
    
}
