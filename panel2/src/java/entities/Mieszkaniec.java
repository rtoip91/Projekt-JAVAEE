/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
 * @author Tomek
 */
@Entity
@Table(name = "Mieszkaniec")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mieszkaniec.findAll", query = "SELECT m FROM Mieszkaniec m"),
    @NamedQuery(name = "Mieszkaniec.findById", query = "SELECT m FROM Mieszkaniec m WHERE m.id = :id"),
    @NamedQuery(name = "Mieszkaniec.findByImie", query = "SELECT m FROM Mieszkaniec m WHERE m.imie = :imie"),
    @NamedQuery(name = "Mieszkaniec.findByNazwisko", query = "SELECT m FROM Mieszkaniec m WHERE m.nazwisko = :nazwisko"),
    @NamedQuery(name = "Mieszkaniec.findByLogin", query = "SELECT m FROM Mieszkaniec m WHERE m.login = :login"),
    @NamedQuery(name = "Mieszkaniec.findByHaslo", query = "SELECT m FROM Mieszkaniec m WHERE m.haslo = :haslo"),
    @NamedQuery(name = "Mieszkaniec.findByNazwa", query = "SELECT m FROM Mieszkaniec m WHERE m.nazwa = :nazwa"),
    @NamedQuery(name = "Mieszkaniec.findByUprawnienieID", query = "SELECT m FROM Mieszkaniec m WHERE m.uprawnienieID = :uprawnienieID"),
    @NamedQuery(name = "Mieszkaniec.findByEmail", query = "SELECT m FROM Mieszkaniec m WHERE m.email = :email"),
    @NamedQuery(name = "Mieszkaniec.findByNrtelefonu", query = "SELECT m FROM Mieszkaniec m WHERE m.nrtelefonu = :nrtelefonu")})
public class Mieszkaniec implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Imie")
    private String imie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Nazwisko")
    private String nazwisko;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Login")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Haslo")
    private String haslo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Nazwa")
    private String nazwa;
    @Column(name = "UprawnienieID")
    private Integer uprawnienieID;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "E_mail")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Nr_telefonu")
    private String nrtelefonu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mieszkaniecID")
    private Collection<Mieszkanie> mieszkanieCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mieszkaniecID")
    private Collection<Sprawa> sprawaCollection;

    public Mieszkaniec() {
    }

    public Mieszkaniec(Integer id) {
        this.id = id;
    }

    public Mieszkaniec(Integer id, String imie, String nazwisko, String login, String haslo, String nazwa, String email, String nrtelefonu) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.login = login;
        this.haslo = haslo;
        this.nazwa = nazwa;
        this.email = email;
        this.nrtelefonu = nrtelefonu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
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

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Integer getUprawnienieID() {
        return uprawnienieID;
    }

    public void setUprawnienieID(Integer uprawnienieID) {
        this.uprawnienieID = uprawnienieID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNrtelefonu() {
        return nrtelefonu;
    }

    public void setNrtelefonu(String nrtelefonu) {
        this.nrtelefonu = nrtelefonu;
    }

    @XmlTransient
    public Collection<Mieszkanie> getMieszkanieCollection() {
        return mieszkanieCollection;
    }

    public void setMieszkanieCollection(Collection<Mieszkanie> mieszkanieCollection) {
        this.mieszkanieCollection = mieszkanieCollection;
    }

    @XmlTransient
    public Collection<Sprawa> getSprawaCollection() {
        return sprawaCollection;
    }

    public void setSprawaCollection(Collection<Sprawa> sprawaCollection) {
        this.sprawaCollection = sprawaCollection;
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
        if (!(object instanceof Mieszkaniec)) {
            return false;
        }
        Mieszkaniec other = (Mieszkaniec) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Mieszkaniec[ id=" + id + " ]";
    }
    
}
