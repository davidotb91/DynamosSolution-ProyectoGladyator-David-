package dl;
// Generated 24/10/2016 17:17:32 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Pago generated by hbm2java
 */
public class Pago  implements java.io.Serializable {


     private Integer idPago;
     private Deportista deportista;
     private Date fechaPago;
     private Date fechaVencimientoPago;
     private String tipoPago;
     private String estado;

    public Pago() {
    }

	
    public Pago(Date fechaPago, Date fechaVencimientoPago, String tipoPago, String estado) {
        this.fechaPago = fechaPago;
        this.fechaVencimientoPago = fechaVencimientoPago;
        this.tipoPago = tipoPago;
        this.estado = estado;
    }
    public Pago(Deportista deportista, Date fechaPago, Date fechaVencimientoPago, String tipoPago, String estado) {
       this.deportista = deportista;
       this.fechaPago = fechaPago;
       this.fechaVencimientoPago = fechaVencimientoPago;
       this.tipoPago = tipoPago;
       this.estado = estado;
    }
   
    public Integer getIdPago() {
        return this.idPago;
    }
    
    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
    }
    public Deportista getDeportista() {
        return this.deportista;
    }
    
    public void setDeportista(Deportista deportista) {
        this.deportista = deportista;
    }
    public Date getFechaPago() {
        return this.fechaPago;
    }
    
    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }
    public Date getFechaVencimientoPago() {
        return this.fechaVencimientoPago;
    }
    
    public void setFechaVencimientoPago(Date fechaVencimientoPago) {
        this.fechaVencimientoPago = fechaVencimientoPago;
    }
    public String getTipoPago() {
        return this.tipoPago;
    }
    
    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }




}


