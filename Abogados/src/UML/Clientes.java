/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author v6222
 */
@Entity
@Table(name = "clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c")
    , @NamedQuery(name = "Clientes.findByDni", query = "SELECT c FROM Clientes c WHERE c.dni = :dni")
    , @NamedQuery(name = "Clientes.findByNombre", query = "SELECT c FROM Clientes c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Clientes.findByApe1", query = "SELECT c FROM Clientes c WHERE c.ape1 = :ape1")
    , @NamedQuery(name = "Clientes.findByApe2", query = "SELECT c FROM Clientes c WHERE c.ape2 = :ape2")
    , @NamedQuery(name = "Clientes.findByDir", query = "SELECT c FROM Clientes c WHERE c.dir = :dir")
    , @NamedQuery(name = "Clientes.findByTel", query = "SELECT c FROM Clientes c WHERE c.tel = :tel")})
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dni")
    private String dni;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "ape1")
    private String ape1;
    @Basic(optional = false)
    @Column(name = "ape2")
    private String ape2;
    @Basic(optional = false)
    @Column(name = "dir")
    private String dir;
    @Basic(optional = false)
    @Column(name = "tel")
    private String tel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientedni")
    private Collection<Casos> casosCollection;

    public Clientes() {
    }

    public Clientes(String dni) {
        this.dni = dni;
    }

    public Clientes(String dni, String nombre, String ape1, String ape2, String dir, String tel) {
        this.dni = dni;
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
        this.dir = dir;
        this.tel = tel;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @XmlTransient
    public Collection<Casos> getCasosCollection() {
        return casosCollection;
    }

    public void setCasosCollection(Collection<Casos> casosCollection) {
        this.casosCollection = casosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dni != null ? dni.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UML.Clientes[ dni=" + dni + " ]";
    }
    
}
