/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bombapatch.model.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author iohan
 */
@Entity
@Table(catalog = "bombapatch", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Time.findAll", query = "SELECT t FROM Time t")
    , @NamedQuery(name = "Time.findByIdTime", query = "SELECT t FROM Time t WHERE t.idTime = :idTime")
    , @NamedQuery(name = "Time.findByNome", query = "SELECT t FROM Time t WHERE t.nome = :nome")
    , @NamedQuery(name = "Time.findByPontuacaoTotal", query = "SELECT t FROM Time t WHERE t.pontuacaoTotal = :pontuacaoTotal")})
public class Time implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_time", nullable = false)
    private Integer idTime;
    @Column(length = 45)
    private String nome;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pontuacao_total", precision = 22)
    private Double pontuacaoTotal;
    @OneToMany(mappedBy = "time")
    private List<JogadorTime> jogadorTimeList;
    @OneToMany(mappedBy = "time")
    private List<UsuarioTime> usuarioTimeList;
    @OneToMany(mappedBy = "time1")
    private List<Partida> partidaList;
    @OneToMany(mappedBy = "time2")
    private List<Partida> partidaList1;

    public Time() {
    }

    public Time(Integer idTime) {
        this.idTime = idTime;
    }

    public Integer getIdTime() {
        return idTime;
    }

    public void setIdTime(Integer idTime) {
        this.idTime = idTime;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPontuacaoTotal() {
        return pontuacaoTotal;
    }

    public void setPontuacaoTotal(Double pontuacaoTotal) {
        this.pontuacaoTotal = pontuacaoTotal;
    }

    @XmlTransient
    public List<JogadorTime> getJogadorTimeList() {
        return jogadorTimeList;
    }

    public void setJogadorTimeList(List<JogadorTime> jogadorTimeList) {
        this.jogadorTimeList = jogadorTimeList;
    }

    @XmlTransient
    public List<UsuarioTime> getUsuarioTimeList() {
        return usuarioTimeList;
    }

    public void setUsuarioTimeList(List<UsuarioTime> usuarioTimeList) {
        this.usuarioTimeList = usuarioTimeList;
    }

    @XmlTransient
    public List<Partida> getPartidaList() {
        return partidaList;
    }

    public void setPartidaList(List<Partida> partidaList) {
        this.partidaList = partidaList;
    }

    @XmlTransient
    public List<Partida> getPartidaList1() {
        return partidaList1;
    }

    public void setPartidaList1(List<Partida> partidaList1) {
        this.partidaList1 = partidaList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTime != null ? idTime.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Time)) {
            return false;
        }
        Time other = (Time) object;
        if ((this.idTime == null && other.idTime != null) || (this.idTime != null && !this.idTime.equals(other.idTime))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bombapatch.model.domain.Time[ idTime=" + idTime + " ]";
    }
    
}
