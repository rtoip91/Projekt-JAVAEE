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
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Imie", nullable = false, length = 20)
    private String imie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Nazwisko", nullable = false, length = 30)
    private String nazwisko;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Login", nullable = false, length = 30)
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Haslo", nullable = false, length = 30)
    private String haslo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Nazwa", nullable = false, length = 50)
    private String nazwa;
    @Column(name = "UprawnienieID")
    private Integer uprawnienieID;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "E_mail", nullable = false, length = 50)
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Nr_telefonu", nullable = false, length = 20)
    private String nrtelefonu;
    @OneToMany(mappedBy = "mieszkaniecID")
    private List<Mieszkanie> mieszkanieList;
    @OneToMany(mappedBy = "mieszkaniecID")
    private List<Sprawa> sprawaList;

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
    public List<Mieszkanie> getMieszkanieList() {
        return mieszkanieList;
    }

    public void setMieszkanieList(List<Mieszkanie> mieszkanieList) {
        this.mieszkanieList = mieszkanieList;
    }

    @XmlTransient
    public List<Sprawa> getSprawaList() {
        return sprawaList;
    }

    public void setSprawaList(List<Sprawa> sprawaList) {
        this.sprawaList = sprawaList;
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
