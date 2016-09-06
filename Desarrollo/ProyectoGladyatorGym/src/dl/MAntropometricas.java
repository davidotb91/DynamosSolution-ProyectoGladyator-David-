/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dl;

import java.io.Serializable;
import java.math.BigDecimal;
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

/**
 *
 * @author desarrolloPC
 */
@Entity
@Table(name = "m_antropometricas")
@NamedQueries({
    @NamedQuery(name = "MAntropometricas.findAll", query = "SELECT m FROM MAntropometricas m")})
public class MAntropometricas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_M_ANTROPOMRTRICAS")
    private Integer idMAntropomrtricas;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "PESO")
    private BigDecimal peso;
    @Basic(optional = false)
    @Column(name = "TALLA")
    private BigDecimal talla;
    @Basic(optional = false)
    @Column(name = "BRAZO_IZQUIERDO")
    private BigDecimal brazoIzquierdo;
    @Basic(optional = false)
    @Column(name = "BRAZO_DERECHO")
    private BigDecimal brazoDerecho;
    @Basic(optional = false)
    @Column(name = "PECHO")
    private BigDecimal pecho;
    @Basic(optional = false)
    @Column(name = "CINTURA")
    private BigDecimal cintura;
    @Column(name = "CADERA")
    private BigDecimal cadera;
    @Basic(optional = false)
    @Column(name = "MUSLO")
    private BigDecimal muslo;
    @Basic(optional = false)
    @Column(name = "PANTORRILLAS")
    private BigDecimal pantorrillas;
    @Column(name = "IRM")
    private BigDecimal irm;
    @Column(name = "GRASA_CORPORAL")
    private BigDecimal grasaCorporal;
    @JoinColumn(name = "ID_DEPORTISTA", referencedColumnName = "ID_DEPORTISTA")
    @ManyToOne
    private Deportista idDeportista;

    public MAntropometricas() {
    }

    public MAntropometricas(Integer idMAntropomrtricas) {
        this.idMAntropomrtricas = idMAntropomrtricas;
    }

    public MAntropometricas(Integer idMAntropomrtricas, BigDecimal peso, BigDecimal talla, BigDecimal brazoIzquierdo, BigDecimal brazoDerecho, BigDecimal pecho, BigDecimal cintura, BigDecimal muslo, BigDecimal pantorrillas) {
        this.idMAntropomrtricas = idMAntropomrtricas;
        this.peso = peso;
        this.talla = talla;
        this.brazoIzquierdo = brazoIzquierdo;
        this.brazoDerecho = brazoDerecho;
        this.pecho = pecho;
        this.cintura = cintura;
        this.muslo = muslo;
        this.pantorrillas = pantorrillas;
    }

    public Integer getIdMAntropomrtricas() {
        return idMAntropomrtricas;
    }

    public void setIdMAntropomrtricas(Integer idMAntropomrtricas) {
        this.idMAntropomrtricas = idMAntropomrtricas;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public BigDecimal getTalla() {
        return talla;
    }

    public void setTalla(BigDecimal talla) {
        this.talla = talla;
    }

    public BigDecimal getBrazoIzquierdo() {
        return brazoIzquierdo;
    }

    public void setBrazoIzquierdo(BigDecimal brazoIzquierdo) {
        this.brazoIzquierdo = brazoIzquierdo;
    }

    public BigDecimal getBrazoDerecho() {
        return brazoDerecho;
    }

    public void setBrazoDerecho(BigDecimal brazoDerecho) {
        this.brazoDerecho = brazoDerecho;
    }

    public BigDecimal getPecho() {
        return pecho;
    }

    public void setPecho(BigDecimal pecho) {
        this.pecho = pecho;
    }

    public BigDecimal getCintura() {
        return cintura;
    }

    public void setCintura(BigDecimal cintura) {
        this.cintura = cintura;
    }

    public BigDecimal getCadera() {
        return cadera;
    }

    public void setCadera(BigDecimal cadera) {
        this.cadera = cadera;
    }

    public BigDecimal getMuslo() {
        return muslo;
    }

    public void setMuslo(BigDecimal muslo) {
        this.muslo = muslo;
    }

    public BigDecimal getPantorrillas() {
        return pantorrillas;
    }

    public void setPantorrillas(BigDecimal pantorrillas) {
        this.pantorrillas = pantorrillas;
    }

    public BigDecimal getIrm() {
        return irm;
    }

    public void setIrm(BigDecimal irm) {
        this.irm = irm;
    }

    public BigDecimal getGrasaCorporal() {
        return grasaCorporal;
    }

    public void setGrasaCorporal(BigDecimal grasaCorporal) {
        this.grasaCorporal = grasaCorporal;
    }

    public Deportista getIdDeportista() {
        return idDeportista;
    }

    public void setIdDeportista(Deportista idDeportista) {
        this.idDeportista = idDeportista;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMAntropomrtricas != null ? idMAntropomrtricas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MAntropometricas)) {
            return false;
        }
        MAntropometricas other = (MAntropometricas) object;
        if ((this.idMAntropomrtricas == null && other.idMAntropomrtricas != null) || (this.idMAntropomrtricas != null && !this.idMAntropomrtricas.equals(other.idMAntropomrtricas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dl.MAntropometricas[ idMAntropomrtricas=" + idMAntropomrtricas + " ]";
    }
    
}
