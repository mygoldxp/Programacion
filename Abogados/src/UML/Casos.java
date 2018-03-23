/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author v6222
 */
@Entity
@Table(name = "casos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Casos.findAll", query = "SELECT c FROM Casos c")
    , @NamedQuery(name = "Casos.findByNumExp", query = "SELECT c FROM Casos c WHERE c.numExp = :numExp")
    , @NamedQuery(name = "Casos.findByFechaI", query = "SELECT c FROM Casos c WHERE c.fechaI = :fechaI")
    , @NamedQuery(name = "Casos.findByFechaF", query = "SELECT c FROM Casos c WHERE c.fechaF = :fechaF")
    , @NamedQuery(name = "Casos.findByEstado", query = "SELECT c FROM Casos c WHERE c.estado = :estado")})
public class Casos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "num_exp")
    private String numExp;
    @Basic(optional = false)
    @Column(name = "fecha_i")
    @Temporal(TemporalType.DATE)
    private Date fechaI;
    @Column(name = "fecha_f")
    @Temporal(TemporalType.DATE)
    private Date fechaF;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @ManyToMany(mappedBy = "casosCollection")
    private Collection<Abogados> abogadosCollection;
    @JoinColumn(name = "Cliente_dni", referencedColumnName = "dni")
    @ManyToOne(optional = false)
    private Clientes clientedni;

    public Casos() {
    }

    public Casos(String numExp) {
        this.numExp = numExp;
    }
    
    public Casos(String numExp, String estado) {
        this.numExp = numExp;
        this.estado = estado;
    }

    public Casos(String numExp, Date fechaI, Date fechaF, String estado, Clientes cliente) {
        this.numExp = numExp;
        this.fechaI = fechaI;
        this.fechaF = fechaF;
        this.estado = estado;
        this.clientedni = cliente;
    }

    public String getNumExp() {
        return numExp;
    }

    public void setNumExp(String numExp) {
        this.numExp = numExp;
    }

    public Date getFechaI() {
        return fechaI;
    }

    public void setFechaI(Date fechaI) {
        this.fechaI = fechaI;
    }

    public Date getFechaF() {
        return fechaF;
    }

    public void setFechaF(Date fechaF) {
        this.fechaF = fechaF;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<Abogados> getAbogadosCollection() {
        return abogadosCollection;
    }

    public void setAbogadosCollection(Collection<Abogados> abogadosCollection) {
        this.abogadosCollection = abogadosCollection;
    }

    public Clientes getClientedni() {
        return clientedni;
    }

    public void setClientedni(Clientes clientedni) {
        this.clientedni = clientedni;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numExp != null ? numExp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Casos)) {
            return false;
        }
        Casos other = (Casos) object;
        if ((this.numExp == null && other.numExp != null) || (this.numExp != null && !this.numExp.equals(other.numExp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UML.Casos[ numExp=" + numExp + " ]";
    }
    
}
