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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Piotrek
 */
@Entity
@Table(name = "Administrator", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"ID"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrator.findAll", query = "SELECT a FROM Administrator a"),
    @NamedQuery(name = "Administrator.findById", query = "SELECT a FROM Administrator a WHERE a.id = :id"),
    @NamedQuery(name = "Administrator.findByImie", query = "SELECT a FROM Administrator a WHERE a.imie = :imie"),
    @NamedQuery(name = "Administrator.findByNazwisko", query = "SELECT a FROM Administrator a WHERE a.nazwisko = :nazwisko"),
    @NamedQuery(name = "Administrator.findByLogin", query = "SELECT a FROM Administrator a WHERE a.login = :login"),
    @NamedQuery(name = "Administrator.findByHaslo", query = "SELECT a FROM Administrator a WHERE a.haslo = :haslo"),
    @NamedQuery(name = "Administrator.findByNazwa", query = "SELECT a FROM Administrator a WHERE a.nazwa = :nazwa"),
    @NamedQuery(name = "Administrator.findByUprawnienieID", query = "SELECT a FROM Administrator a WHERE a.uprawnienieID = :uprawnienieID")})
public class Administrator implements Serializable {
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
    @JoinColumn(name = "BudynekID", referencedColumnName = "ID")
    @ManyToOne
    private Budynek budynekID;

    public Administrator() {
    }

    public Administrator(Integer id) {
        this.id = id;
    }

    public Administrator(Integer id, String imie, String nazwisko, String login, String haslo, String nazwa) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.login = login;
        this.haslo = haslo;
        this.nazwa = nazwa;
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
        if (!(object instanceof Administrator)) {
            return false;
        }
        Administrator other = (Administrator) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Administrator[ id=" + id + " ]";
    }
    
}
