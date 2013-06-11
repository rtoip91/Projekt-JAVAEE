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
 * @author Piotrek
 */
@Entity
@Table(name = "Sprawa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sprawa.findAll", query = "SELECT s FROM Sprawa s"),
    @NamedQuery(name = "Sprawa.findById", query = "SELECT s FROM Sprawa s WHERE s.id = :id"),
    @NamedQuery(name = "Sprawa.findByStatus", query = "SELECT s FROM Sprawa s WHERE s.status = :status")})
public class Sprawa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "Tresc", nullable = false, length = 65535)
    private String tresc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Status", nullable = false, length = 20)
    private String status;
    @JoinColumn(name = "MieszkaniecID", referencedColumnName = "ID")
    @ManyToOne
    private Mieszkaniec mieszkaniecID;

    public Sprawa() {
    }

    public Sprawa(Integer id) {
        this.id = id;
    }

    public Sprawa(Integer id, String tresc, String status) {
        this.id = id;
        this.tresc = tresc;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Mieszkaniec getMieszkaniecID() {
        return mieszkaniecID;
    }

    public void setMieszkaniecID(Mieszkaniec mieszkaniecID) {
        this.mieszkaniecID = mieszkaniecID;
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
        if (!(object instanceof Sprawa)) {
            return false;
        }
        Sprawa other = (Sprawa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Sprawa[ id=" + id + " ]";
    }
    
}
