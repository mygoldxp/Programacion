/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UMLBD;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author v6222
 */
@Entity
@Table(name = "clasificacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clasificacion.findAll", query = "SELECT c FROM Clasificacion c")
    , @NamedQuery(name = "Clasificacion.findById", query = "SELECT c FROM Clasificacion c WHERE c.id = :id")
    , @NamedQuery(name = "Clasificacion.findByPunto", query = "SELECT c FROM Clasificacion c WHERE c.punto = :punto")})
public class Clasificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "punto")
    private int punto;
    @OneToMany(mappedBy = "idpelea")
    private Collection<Clasificacion> clasificacionCollection;
    @JoinColumn(name = "idpelea", referencedColumnName = "id")
    @ManyToOne
    private Clasificacion idpelea;
    @JoinColumn(name = "idequipo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Equipo idequipo;
    @JoinColumn(name = "idjornada", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Jornada idjornada;

    public Clasificacion() {
    }

    public Clasificacion(Integer id) {
        this.id = id;
    }

    public Clasificacion(Integer id, int punto) {
        this.id = id;
        this.punto = punto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPunto() {
        return punto;
    }

    public void setPunto(int punto) {
        this.punto = punto;
    }

    @XmlTransient
    public Collection<Clasificacion> getClasificacionCollection() {
        return clasificacionCollection;
    }

    public void setClasificacionCollection(Collection<Clasificacion> clasificacionCollection) {
        this.clasificacionCollection = clasificacionCollection;
    }

    public Clasificacion getIdpelea() {
        return idpelea;
    }

    public void setIdpelea(Clasificacion idpelea) {
        this.idpelea = idpelea;
    }

    public Equipo getIdequipo() {
        return idequipo;
    }

    public void setIdequipo(Equipo idequipo) {
        this.idequipo = idequipo;
    }

    public Jornada getIdjornada() {
        return idjornada;
    }

    public void setIdjornada(Jornada idjornada) {
        this.idjornada = idjornada;
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
        if (!(object instanceof Clasificacion)) {
            return false;
        }
        Clasificacion other = (Clasificacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UMLBD.Clasificacion[ id=" + id + " ]";
    }
    
}
