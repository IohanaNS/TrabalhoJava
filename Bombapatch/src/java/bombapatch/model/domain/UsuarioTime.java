/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bombapatch.model.domain;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author iohan
 */
@Entity
@Table(name = "usuario_time", catalog = "bombapatch", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioTime.findAll", query = "SELECT u FROM UsuarioTime u")
    , @NamedQuery(name = "UsuarioTime.findByIdusuarioTime", query = "SELECT u FROM UsuarioTime u WHERE u.idusuarioTime = :idusuarioTime")})
public class UsuarioTime implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idusuario_time", nullable = false)
    private Integer idUsuarioTime;
    @JoinColumn(name = "idcampeonato", referencedColumnName = "id_campeonato")
    @ManyToOne
    private Campeonato campeonato;
    @JoinColumn(name = "idtime", referencedColumnName = "id_time")
    @ManyToOne
    private Time time;
    @JoinColumn(name = "idusuario", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario usuario;

    public UsuarioTime() {
    }

    public UsuarioTime(Integer idUsuarioTime) {
        this.idUsuarioTime = idUsuarioTime;
    }

    public Integer getUsuarioTime() {
        return idUsuarioTime;
    }

    public void setIdUsuarioTime(Integer idUsuarioTime) {
        this.idUsuarioTime = idUsuarioTime;
    }

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuarioTime != null ? idUsuarioTime.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioTime)) {
            return false;
        }
        UsuarioTime other = (UsuarioTime) object;
        if ((this.idUsuarioTime == null && other.idUsuarioTime != null) || (this.idUsuarioTime != null && !this.idUsuarioTime.equals(other.idUsuarioTime))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bombapatch.model.domain.UsuarioTime[ idusuarioTime=" + idUsuarioTime + " ]";
    }
    
}
