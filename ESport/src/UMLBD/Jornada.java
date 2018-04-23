/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UMLBD;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author v6222
 */
@Entity
@Table(name = "jornada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jornada.findAll", query = "SELECT j FROM Jornada j")
    , @NamedQuery(name = "Jornada.findById", query = "SELECT j FROM Jornada j WHERE j.id = :id")
    , @NamedQuery(name = "Jornada.findByFinicio", query = "SELECT j FROM Jornada j WHERE j.finicio = :finicio")
    , @NamedQuery(name = "Jornada.findByFfin", query = "SELECT j FROM Jornada j WHERE j.ffin = :ffin")
    , @NamedQuery(name = "Jornada.findByHinicio", query = "SELECT j FROM Jornada j WHERE j.hinicio = :hinicio")
    , @NamedQuery(name = "Jornada.findByHfin", query = "SELECT j FROM Jornada j WHERE j.hfin = :hfin")
    , @NamedQuery(name = "Jornada.findByNombre", query = "SELECT j FROM Jornada j WHERE j.nombre = :nombre")})
public class Jornada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "finicio")
    @Temporal(TemporalType.DATE)
    private Date finicio;
    @Column(name = "ffin")
    @Temporal(TemporalType.DATE)
    private Date ffin;
    @Basic(optional = false)
    @Column(name = "hinicio")
    @Temporal(TemporalType.TIME)
    private Date hinicio;
    @Column(name = "hfin")
    @Temporal(TemporalType.TIME)
    private Date hfin;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idjornada")
    private Collection<Clasificacion> clasificacionCollection;

    public Jornada() {
    }

    public Jornada(Integer id) {
        this.id = id;
    }

    public Jornada(Integer id, Date finicio, Date hinicio, String nombre) {
        this.id = id;
        this.finicio = finicio;
        this.hinicio = hinicio;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFinicio() {
        return finicio;
    }

    public void setFinicio(Date finicio) {
        this.finicio = finicio;
    }

    public Date getFfin() {
        return ffin;
    }

    public void setFfin(Date ffin) {
        this.ffin = ffin;
    }

    public Date getHinicio() {
        return hinicio;
    }

    public void setHinicio(Date hinicio) {
        this.hinicio = hinicio;
    }

    public Date getHfin() {
        return hfin;
    }

    public void setHfin(Date hfin) {
        this.hfin = hfin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Clasificacion> getClasificacionCollection() {
        return clasificacionCollection;
    }

    public void setClasificacionCollection(Collection<Clasificacion> clasificacionCollection) {
        this.clasificacionCollection = clasificacionCollection;
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
        if (!(object instanceof Jornada)) {
            return false;
        }
        Jornada other = (Jornada) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UMLBD.Jornada[ id=" + id + " ]";
    }
    
}
