/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dl;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author desarrolloPC
 */
@Entity
@Table(name = "deportista")
@NamedQueries({
    @NamedQuery(name = "Deportista.findAll", query = "SELECT d FROM Deportista d")})
public class Deportista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_DEPORTISTA")
    private Integer idDeportista;
    @Basic(optional = false)
    @Column(name = "PRIMER_NOMBRE")
    private String primerNombre;
    @Basic(optional = false)
    @Column(name = "SEGUNDO_NOMBRE")
    private String segundoNombre;
    @Basic(optional = false)
    @Column(name = "APELLIDO_PATERNO")
    private String apellidoPaterno;
    @Basic(optional = false)
    @Column(name = "APELLIDO_MATERNO")
    private String apellidoMaterno;
    @Basic(optional = false)
    @Column(name = "GENERO")
    private String genero;
    @Basic(optional = false)
    @Column(name = "CEDULA")
    private String cedula;
    @Column(name = "CORREO")
    private String correo;
    @Basic(optional = false)
    @Column(name = "FECHA_NACIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @Column(name = "EDAD")
    private int edad;
    @Column(name = "FACEBOOK")
    private String facebook;
    @Basic(optional = false)
    @Column(name = "CELULAR")
    private String celular;
    @Basic(optional = false)
    @Column(name = "TELEFONO_FIJO")
    private String telefonoFijo;
    @OneToMany(mappedBy = "idDeportista")
    private List<MAntropometricas> mAntropometricasList;

    public Deportista() {
    }

    public Deportista(Integer idDeportista) {
        this.idDeportista = idDeportista;
    }

    public Deportista(Integer idDeportista, String primerNombre, String segundoNombre, String apellidoPaterno, String apellidoMaterno, String genero, String cedula, Date fechaNacimiento, int edad, String celular, String telefonoFijo) {
        this.idDeportista = idDeportista;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.genero = genero;
        this.cedula = cedula;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.celular = celular;
        this.telefonoFijo = telefonoFijo;
    }

    public Integer getIdDeportista() {
        return idDeportista;
    }

    public void setIdDeportista(Integer idDeportista) {
        this.idDeportista = idDeportista;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public List<MAntropometricas> getMAntropometricasList() {
        return mAntropometricasList;
    }

    public void setMAntropometricasList(List<MAntropometricas> mAntropometricasList) {
        this.mAntropometricasList = mAntropometricasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDeportista != null ? idDeportista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deportista)) {
            return false;
        }
        Deportista other = (Deportista) object;
        if ((this.idDeportista == null && other.idDeportista != null) || (this.idDeportista != null && !this.idDeportista.equals(other.idDeportista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dl.Deportista[ idDeportista=" + idDeportista + " ]";
    }
    
}
