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
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author v6222
 */
@Entity
@Table(name = "jugador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jugador.findAll", query = "SELECT j FROM Jugador j")
    , @NamedQuery(name = "Jugador.findById", query = "SELECT j FROM Jugador j WHERE j.id = :id")
    , @NamedQuery(name = "Jugador.findByNombre", query = "SELECT j FROM Jugador j WHERE j.nombre = :nombre")
    , @NamedQuery(name = "Jugador.findByApe1", query = "SELECT j FROM Jugador j WHERE j.ape1 = :ape1")
    , @NamedQuery(name = "Jugador.findByApe2", query = "SELECT j FROM Jugador j WHERE j.ape2 = :ape2")
    , @NamedQuery(name = "Jugador.findByNick", query = "SELECT j FROM Jugador j WHERE j.nick = :nick")
    , @NamedQuery(name = "Jugador.findBySueldo", query = "SELECT j FROM Jugador j WHERE j.sueldo = :sueldo")
    , @NamedQuery(name = "Jugador.findByFAlta", query = "SELECT j FROM Jugador j WHERE j.fAlta = :fAlta")
    , @NamedQuery(name = "Jugador.findByEstado", query = "SELECT j FROM Jugador j WHERE j.estado = :estado")})
public class Jugador implements Serializable {

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
    private int ape1;
    @Column(name = "ape2")
    private Integer ape2;
    @Basic(optional = false)
    @Column(name = "nick")
    private int nick;
    @Basic(optional = false)
    @Column(name = "sueldo")
    private float sueldo;
    @Basic(optional = false)
    @Column(name = "f_alta")
    @Temporal(TemporalType.DATE)
    private Date fAlta;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;
    @JoinColumn(name = "equipo", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Equipo equipo;

    public Jugador() {
    }

    public Jugador(Integer id) {
        this.id = id;
    }

    public Jugador(Integer id, String nombre, int ape1, int nick, float sueldo, Date fAlta, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.ape1 = ape1;
        this.nick = nick;
        this.sueldo = sueldo;
        this.fAlta = fAlta;
        this.estado = estado;
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

    public int getApe1() {
        return ape1;
    }

    public void setApe1(int ape1) {
        this.ape1 = ape1;
    }

    public Integer getApe2() {
        return ape2;
    }

    public void setApe2(Integer ape2) {
        this.ape2 = ape2;
    }

    public int getNick() {
        return nick;
    }

    public void setNick(int nick) {
        this.nick = nick;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    public Date getFAlta() {
        return fAlta;
    }

    public void setFAlta(Date fAlta) {
        this.fAlta = fAlta;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
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
        if (!(object instanceof Jugador)) {
            return false;
        }
        Jugador other = (Jugador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UMLBD.Jugador[ id=" + id + " ]";
    }
    
}
