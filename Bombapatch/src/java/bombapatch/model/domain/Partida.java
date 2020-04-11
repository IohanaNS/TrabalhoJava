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
@Table(catalog = "bombapatch", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Partida.findAll", query = "SELECT p FROM Partida p")
    , @NamedQuery(name = "Partida.findByIdPartida", query = "SELECT p FROM Partida p WHERE p.idPartida = :idPartida")
    , @NamedQuery(name = "Partida.findByNumPartida", query = "SELECT p FROM Partida p WHERE p.numPartida = :numPartida")
    , @NamedQuery(name = "Partida.findByPlacarTime1", query = "SELECT p FROM Partida p WHERE p.placarTime1 = :placarTime1")
    , @NamedQuery(name = "Partida.findByPlacarTime2", query = "SELECT p FROM Partida p WHERE p.placarTime2 = :placarTime2")})
public class Partida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_partida", nullable = false)
    private Integer idPartida;
    @Column(name = "num_partida")
    private Integer numPartida;
    @Column(name = "placar_time1")
    private Integer placarTime1;
    @Column(name = "placar_time2")
    private Integer placarTime2;
    @JoinColumn(name = "id_campeonato", referencedColumnName = "id_campeonato")
    @ManyToOne
    private Campeonato campeonato;
    @JoinColumn(name = "time1", referencedColumnName = "id_time")
    @ManyToOne
    private Time time1;
    @JoinColumn(name = "time2", referencedColumnName = "id_time")
    @ManyToOne
    private Time time2;

    public Partida() {
    }

    public Partida(Integer idPartida) {
        this.idPartida = idPartida;
    }

    public Integer getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(Integer idPartida) {
        this.idPartida = idPartida;
    }

    public Integer getNumPartida() {
        return numPartida;
    }

    public void setNumPartida(Integer numPartida) {
        this.numPartida = numPartida;
    }

    public Integer getPlacarTime1() {
        return placarTime1;
    }

    public void setPlacarTime1(Integer placarTime1) {
        this.placarTime1 = placarTime1;
    }

    public Integer getPlacarTime2() {
        return placarTime2;
    }

    public void setPlacarTime2(Integer placarTime2) {
        this.placarTime2 = placarTime2;
    }

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }

    public Time getTime1() {
        return time1;
    }

    public void setTime1(Time time1) {
        this.time1 = time1;
    }

    public Time getTime2() {
        return time2;
    }

    public void setTime2(Time time2) {
        this.time2 = time2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPartida != null ? idPartida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partida)) {
            return false;
        }
        Partida other = (Partida) object;
        if ((this.idPartida == null && other.idPartida != null) || (this.idPartida != null && !this.idPartida.equals(other.idPartida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bombapatch.model.domain.Partida[ idPartida=" + idPartida + " ]";
    }
    
}
