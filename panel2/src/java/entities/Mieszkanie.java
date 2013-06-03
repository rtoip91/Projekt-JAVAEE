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
@Table(name = "Mieszkanie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mieszkanie.findAll", query = "SELECT m FROM Mieszkanie m"),
    @NamedQuery(name = "Mieszkanie.findById", query = "SELECT m FROM Mieszkanie m WHERE m.id = :id"),
    @NamedQuery(name = "Mieszkanie.findByNrPosesji", query = "SELECT m FROM Mieszkanie m WHERE m.nrPosesji = :nrPosesji"),
    @NamedQuery(name = "Mieszkanie.findByMetrarz", query = "SELECT m FROM Mieszkanie m WHERE m.metrarz = :metrarz"),
    @NamedQuery(name = "Mieszkanie.findByObciazenie", query = "SELECT m FROM Mieszkanie m WHERE m.obciazenie = :obciazenie"),
    @NamedQuery(name = "Mieszkanie.findByMieszkaniecID", query = "SELECT m FROM Mieszkanie m WHERE m.mieszkaniecID = :mieszkaniecID"),
    @NamedQuery(name = "Mieszkanie.findByBudynekID", query = "SELECT m FROM Mieszkanie m WHERE m.budynekID = :budynekID"),
    @NamedQuery(name = "Mieszkanie.findByNazwa", query = "SELECT m FROM Mieszkanie m WHERE m.nazwa = :nazwa"),
    @NamedQuery(name = "Mieszkanie.findByRyczaltogrzewania", query = "SELECT m FROM Mieszkanie m WHERE m.ryczaltogrzewania = :ryczaltogrzewania"),
    @NamedQuery(name = "Mieszkanie.findByZuzycieciepla", query = "SELECT m FROM Mieszkanie m WHERE m.zuzycieciepla = :zuzycieciepla")})
public class Mieszkanie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Nr_Posesji")
    private String nrPosesji;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Metrarz")
    private int metrarz;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Obciazenie")
    private float obciazenie;
    @Column(name = "MieszkaniecID")
    private Integer mieszkaniecID;
    @Column(name = "BudynekID")
    private Integer budynekID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Nazwa")
    private String nazwa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Ryczalt_ogrzewania")
    private float ryczaltogrzewania;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Zuzycie_ciepla")
    private float zuzycieciepla;

    public Mieszkanie() {
    }

    public Mieszkanie(Integer id) {
        this.id = id;
    }

    public Mieszkanie(Integer id, String nrPosesji, int metrarz, float obciazenie, String nazwa, float ryczaltogrzewania, float zuzycieciepla) {
        this.id = id;
        this.nrPosesji = nrPosesji;
        this.metrarz = metrarz;
        this.obciazenie = obciazenie;
        this.nazwa = nazwa;
        this.ryczaltogrzewania = ryczaltogrzewania;
        this.zuzycieciepla = zuzycieciepla;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNrPosesji() {
        return nrPosesji;
    }

    public void setNrPosesji(String nrPosesji) {
        this.nrPosesji = nrPosesji;
    }

    public int getMetrarz() {
        return metrarz;
    }

    public void setMetrarz(int metrarz) {
        this.metrarz = metrarz;
    }

    public float getObciazenie() {
        return obciazenie;
    }

    public void setObciazenie(float obciazenie) {
        this.obciazenie = obciazenie;
    }

    public Integer getMieszkaniecID() {
        return mieszkaniecID;
    }

    public void setMieszkaniecID(Integer mieszkaniecID) {
        this.mieszkaniecID = mieszkaniecID;
    }

    public Integer getBudynekID() {
        return budynekID;
    }

    public void setBudynekID(Integer budynekID) {
        this.budynekID = budynekID;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public float getRyczaltogrzewania() {
        return ryczaltogrzewania;
    }

    public void setRyczaltogrzewania(float ryczaltogrzewania) {
        this.ryczaltogrzewania = ryczaltogrzewania;
    }

    public float getZuzycieciepla() {
        return zuzycieciepla;
    }

    public void setZuzycieciepla(float zuzycieciepla) {
        this.zuzycieciepla = zuzycieciepla;
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
        if (!(object instanceof Mieszkanie)) {
            return false;
        }
        Mieszkanie other = (Mieszkanie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Mieszkanie[ id=" + id + " ]";
    }
    
}
