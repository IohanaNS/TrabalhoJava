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
@Table(name = "campeonato_estatistica", catalog = "bombapatch", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CampeonatoEstatistica.findAll", query = "SELECT c FROM CampeonatoEstatistica c")
    , @NamedQuery(name = "CampeonatoEstatistica.findByIdEstatistica", query = "SELECT c FROM CampeonatoEstatistica c WHERE c.idEstatistica = :idEstatistica")
    , @NamedQuery(name = "CampeonatoEstatistica.findByPontuacao", query = "SELECT c FROM CampeonatoEstatistica c WHERE c.pontuacao = :pontuacao")
    , @NamedQuery(name = "CampeonatoEstatistica.findByColocacao", query = "SELECT c FROM CampeonatoEstatistica c WHERE c.colocacao = :colocacao")})
public class CampeonatoEstatistica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estatistica", nullable = false)
    private Integer idEstatistica;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 22)
    private Double pontuacao;
    private Integer colocacao;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario usuario;
    @JoinColumn(name = "idcampeonato", referencedColumnName = "id_campeonato")
    @ManyToOne
    private Campeonato campeonato;

    public CampeonatoEstatistica() {
    }

    public CampeonatoEstatistica(Integer idEstatistica) {
        this.idEstatistica = idEstatistica;
    }

    public Integer getIdEstatistica() {
        return idEstatistica;
    }

    public void setIdEstatistica(Integer idEstatistica) {
        this.idEstatistica = idEstatistica;
    }

    public Double getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Double pontuacao) {
        this.pontuacao = pontuacao;
    }

    public Integer getColocacao() {
        return colocacao;
    }

    public void setColocacao(Integer colocacao) {
        this.colocacao = colocacao;
    }

    public Usuario getIdUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstatistica != null ? idEstatistica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CampeonatoEstatistica)) {
            return false;
        }
        CampeonatoEstatistica other = (CampeonatoEstatistica) object;
        if ((this.idEstatistica == null && other.idEstatistica != null) || (this.idEstatistica != null && !this.idEstatistica.equals(other.idEstatistica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bombapatch.model.domain.CampeonatoEstatistica[ idEstatistica=" + idEstatistica + " ]";
    }
    
}
