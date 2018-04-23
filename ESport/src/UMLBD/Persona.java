/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UMLBD;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author v6222
 */
@Entity
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")
    , @NamedQuery(name = "Persona.findById", query = "SELECT p FROM Persona p WHERE p.id = :id")
    , @NamedQuery(name = "Persona.findByNombre", query = "SELECT p FROM Persona p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Persona.findByApe1", query = "SELECT p FROM Persona p WHERE p.ape1 = :ape1")
    , @NamedQuery(name = "Persona.findByApe2", query = "SELECT p FROM Persona p WHERE p.ape2 = :ape2")
    , @NamedQuery(name = "Persona.findByTelf", query = "SELECT p FROM Persona p WHERE p.telf = :telf")
    , @NamedQuery(name = "Persona.findByFAlta", query = "SELECT p FROM Persona p WHERE p.fAlta = :fAlta")
    , @NamedQuery(name = "Persona.findByUser", query = "SELECT p FROM Persona p WHERE p.user = :user")
    , @NamedQuery(name = "Persona.findByPass", query = "SELECT p FROM Persona p WHERE p.pass = :pass")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "ape1")
    private String ape1;
    @Column(name = "ape2")
    private String ape2;
    @Column(name = "telf")
    private String telf;
    @Basic(optional = false)
    @Column(name = "f_alta")
    @Temporal(TemporalType.DATE)
    private Date fAlta;
    @Basic(optional = false)
    @Column(name = "user")
    private String user;
    @Basic(optional = false)
    @Column(name = "pass")
    private String pass;

    public Persona() {
    }

    public Persona(Integer id) {
        this.id = id;
    }

    public Persona(Integer id, String nombre, String ape1, Date fAlta, String user, String pass) {
        this.id = id;
        this.nombre = nombre;
        this.ape1 = ape1;
        this.fAlta = fAlta;
        this.user = user;
        this.pass = pass;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApe1() {
        return ape1;
    }

    public void setApe1(String ape1) {
        this.ape1 = ape1;
    }

    public String getApe2() {
        return ape2;
    }

    public void setApe2(String ape2) {
        this.ape2 = ape2;
    }

    public String getTelf() {
        return telf;
    }

    public void setTelf(String telf) {
        this.telf = telf;
    }

    public Date getFAlta() {
        return fAlta;
    }

    public void setFAlta(Date fAlta) {
        this.fAlta = fAlta;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UMLBD.Persona[ id=" + id + " ]";
    }
    
}
