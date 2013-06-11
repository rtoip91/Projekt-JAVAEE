/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Piotrek
 */
@Entity
@Table(name = "Budynek")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Budynek.findAll", query = "SELECT b FROM Budynek b"),
    @NamedQuery(name = "Budynek.findById", query = "SELECT b FROM Budynek b WHERE b.id = :id"),
    @NamedQuery(name = "Budynek.findByMiasto", query = "SELECT b FROM Budynek b WHERE b.miasto = :miasto"),
    @NamedQuery(name = "Budynek.findByUlica", query = "SELECT b FROM Budynek b WHERE b.ulica = :ulica"),
    @NamedQuery(name = "Budynek.findByKodPocztowy", query = "SELECT b FROM Budynek b WHERE b.kodPocztowy = :kodPocztowy"),
    @NamedQuery(name = "Budynek.findByIloscMieszkan", query = "SELECT b FROM Budynek b WHERE b.iloscMieszkan = :iloscMieszkan"),
    @NamedQuery(name = "Budynek.findByPowierzchnia", query = "SELECT b FROM Budynek b WHERE b.powierzchnia = :powierzchnia"),
    @NamedQuery(name = "Budynek.findByObciazenieBudynku", query = "SELECT b FROM Budynek b WHERE b.obciazenieBudynku = :obciazenieBudynku"),
    @NamedQuery(name = "Budynek.findByNrDzialki", query = "SELECT b FROM Budynek b WHERE b.nrDzialki = :nrDzialki"),
    @NamedQuery(name = "Budynek.findByNazwa", query = "SELECT b FROM Budynek b WHERE b.nazwa = :nazwa")})
public class Budynek implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Miasto", nullable = false, length = 30)
    private String miasto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Ulica", nullable = false, length = 50)
    private String ulica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "KodPocztowy", nullable = false, length = 10)
    private String kodPocztowy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IloscMieszkan", nullable = false)
    private int iloscMieszkan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Powierzchnia", nullable = false)
    private int powierzchnia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ObciazenieBudynku", nullable = false)
    private float obciazenieBudynku;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "NrDzialki", nullable = false, length = 10)
    private String nrDzialki;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Nazwa", nullable = false, length = 30)
    private String nazwa;
    @OneToMany(mappedBy = "budynekID")
    private List<Mieszkanie> mieszkanieList;
    @OneToMany(mappedBy = "budynekID")
    private List<Ogloszenie> ogloszenieList;
    @OneToMany(mappedBy = "budynekID")
    private List<Administrator> administratorList;

    public Budynek() {
    }

    public Budynek(Integer id) {
        this.id = id;
    }

    public Budynek(Integer id, String miasto, String ulica, String kodPocztowy, int iloscMieszkan, int powierzchnia, float obciazenieBudynku, String nrDzialki, String nazwa) {
        this.id = id;
        this.miasto = miasto;
        this.ulica = ulica;
        this.kodPocztowy = kodPocztowy;
        this.iloscMieszkan = iloscMieszkan;
        this.powierzchnia = powierzchnia;
        this.obciazenieBudynku = obciazenieBudynku;
        this.nrDzialki = nrDzialki;
        this.nazwa = nazwa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    public int getIloscMieszkan() {
        return iloscMieszkan;
    }

    public void setIloscMieszkan(int iloscMieszkan) {
        this.iloscMieszkan = iloscMieszkan;
    }

    public int getPowierzchnia() {
        return powierzchnia;
    }

    public void setPowierzchnia(int powierzchnia) {
        this.powierzchnia = powierzchnia;
    }

    public float getObciazenieBudynku() {
        return obciazenieBudynku;
    }

    public void setObciazenieBudynku(float obciazenieBudynku) {
        this.obciazenieBudynku = obciazenieBudynku;
    }

    public String getNrDzialki() {
        return nrDzialki;
    }

    public void setNrDzialki(String nrDzialki) {
        this.nrDzialki = nrDzialki;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @XmlTransient
    public List<Mieszkanie> getMieszkanieList() {
        return mieszkanieList;
    }

    public void setMieszkanieList(List<Mieszkanie> mieszkanieList) {
        this.mieszkanieList = mieszkanieList;
    }

    @XmlTransient
    public List<Ogloszenie> getOgloszenieList() {
        return ogloszenieList;
    }

    public void setOgloszenieList(List<Ogloszenie> ogloszenieList) {
        this.ogloszenieList = ogloszenieList;
    }

    @XmlTransient
    public List<Administrator> getAdministratorList() {
        return administratorList;
    }

    public void setAdministratorList(List<Administrator> administratorList) {
        this.administratorList = administratorList;
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
        if (!(object instanceof Budynek)) {
            return false;
        }
        Budynek other = (Budynek) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return (miasto+" "+ulica+" "+nrDzialki);
    }
    
}
