/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author v6222
 */
@Entity
@Table(name = "abogados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Abogados.findAll", query = "SELECT a FROM Abogados a")
    , @NamedQuery(name = "Abogados.findByDni", query = "SELECT a FROM Abogados a WHERE a.dni = :dni")
    , @NamedQuery(name = "Abogados.findByNombre", query = "SELECT a FROM Abogados a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Abogados.findByApe1", query = "SELECT a FROM Abogados a WHERE a.ape1 = :ape1")
    , @NamedQuery(name = "Abogados.findByApe2", query = "SELECT a FROM Abogados a WHERE a.ape2 = :ape2")
    , @NamedQuery(name = "Abogados.findByDir", query = "SELECT a FROM Abogados a WHERE a.dir = :dir")})
public class Abogados implements Serializable {

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
    @JoinTable(name = "abogado_lleva_casos", joinColumns = {
        @JoinColumn(name = "Abogado_dni", referencedColumnName = "dni")}, inverseJoinColumns = {
        @JoinColumn(name = "Caso_expediente", referencedColumnName = "num_exp")})
    @ManyToMany
    private Collection<Casos> casosCollection;

    public Abogados() {
    }

    public Abogados(String dni) {
        this.dni = dni;
    }

    public Abogados(String dni, String nombre, String ape1, String ape2, String dir) {
        this.dni = dni;
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
        this.dir = dir;
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
        if (!(object instanceof Abogados)) {
            return false;
        }
        Abogados other = (Abogados) object;
        if ((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UML.Abogados[ dni=" + dni + " ]";
    }
    
}
