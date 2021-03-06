/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Piotrek
 */
@Entity
@Table(name = "Oplata")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oplata.findAll", query = "SELECT o FROM Oplata o"),
    @NamedQuery(name = "Oplata.findById", query = "SELECT o FROM Oplata o WHERE o.id = :id"),
    @NamedQuery(name = "Oplata.findByKwota", query = "SELECT o FROM Oplata o WHERE o.kwota = :kwota"),
    @NamedQuery(name = "Oplata.findByData", query = "SELECT o FROM Oplata o WHERE o.data = :data"),
    @NamedQuery(name = "Oplata.findByStatus", query = "SELECT o FROM Oplata o WHERE o.status = :status"),
    @NamedQuery(name = "Oplata.findByTyp", query = "SELECT o FROM Oplata o WHERE o.typ = :typ")})
public class Oplata implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Kwota", nullable = false)
    private float kwota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Data", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "Opis", nullable = false, length = 65535)
    private String opis;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Status", nullable = false, length = 10)
    private String status;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Typ", nullable = false, length = 30)
    private String typ;
    @JoinColumn(name = "MieszkanieID", referencedColumnName = "ID")
    @ManyToOne
    private Mieszkanie mieszkanieID;

    public Oplata() {
    }

    public Oplata(Integer id) {
        this.id = id;
    }

    public Oplata(Integer id, float kwota, Date data, String opis, String status, String typ) {
        this.id = id;
        this.kwota = kwota;
        this.data = data;
        this.opis = opis;
        this.status = status;
        this.typ = typ;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getKwota() {
        return kwota;
    }

    public void setKwota(float kwota) {
        this.kwota = kwota;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public Mieszkanie getMieszkanieID() {
        return mieszkanieID;
    }

    public void setMieszkanieID(Mieszkanie mieszkanieID) {
        this.mieszkanieID = mieszkanieID;
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
        if (!(object instanceof Oplata)) {
            return false;
        }
        Oplata other = (Oplata) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Oplata[ id=" + id + " ]";
    }
    
}
