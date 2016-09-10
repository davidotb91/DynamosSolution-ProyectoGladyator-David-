package dl;
// Generated 08/09/2016 12:30:04 by Hibernate Tools 4.3.1



/**
 * MAntropometricas generated by hbm2java
 */
public class MAntropometricas  implements java.io.Serializable {


     private Integer idMAntropomrtricas;
     private Deportista deportista;
     private float peso;
     private float talla;
     private float brazoIzquierdo;
     private float brazoDerecho;
     private float pecho;
     private float cintura;
     private Float cadera;
     private float muslo;
     private Integer irm;
     private Integer grasaCorporal;

    public MAntropometricas() {
    }

	
    public MAntropometricas(float peso, float talla, float brazoIzquierdo, float brazoDerecho, float pecho, float cintura, float muslo) {
        this.peso = peso;
        this.talla = talla;
        this.brazoIzquierdo = brazoIzquierdo;
        this.brazoDerecho = brazoDerecho;
        this.pecho = pecho;
        this.cintura = cintura;
        this.muslo = muslo;
    }
    public MAntropometricas(Deportista deportista, float peso, float talla, float brazoIzquierdo, float brazoDerecho, float pecho, float cintura, Float cadera, float muslo, Integer irm, Integer grasaCorporal) {
       this.deportista = deportista;
       this.peso = peso;
       this.talla = talla;
       this.brazoIzquierdo = brazoIzquierdo;
       this.brazoDerecho = brazoDerecho;
       this.pecho = pecho;
       this.cintura = cintura;
       this.cadera = cadera;
       this.muslo = muslo;
       this.irm = irm;
       this.grasaCorporal = grasaCorporal;
    }
   
    public Integer getIdMAntropomrtricas() {
        return this.idMAntropomrtricas;
    }
    
    public void setIdMAntropomrtricas(Integer idMAntropomrtricas) {
        this.idMAntropomrtricas = idMAntropomrtricas;
    }
    public Deportista getDeportista() {
        return this.deportista;
    }
    
    public void setDeportista(Deportista deportista) {
        this.deportista = deportista;
    }
    public float getPeso() {
        return this.peso;
    }
    
    public void setPeso(float peso) {
        this.peso = peso;
    }
    public float getTalla() {
        return this.talla;
    }
    
    public void setTalla(float talla) {
        this.talla = talla;
    }
    public float getBrazoIzquierdo() {
        return this.brazoIzquierdo;
    }
    
    public void setBrazoIzquierdo(float brazoIzquierdo) {
        this.brazoIzquierdo = brazoIzquierdo;
    }
    public float getBrazoDerecho() {
        return this.brazoDerecho;
    }
    
    public void setBrazoDerecho(float brazoDerecho) {
        this.brazoDerecho = brazoDerecho;
    }
    public float getPecho() {
        return this.pecho;
    }
    
    public void setPecho(float pecho) {
        this.pecho = pecho;
    }
    public float getCintura() {
        return this.cintura;
    }
    
    public void setCintura(float cintura) {
        this.cintura = cintura;
    }
    public Float getCadera() {
        return this.cadera;
    }
    
    public void setCadera(Float cadera) {
        this.cadera = cadera;
    }
    public float getMuslo() {
        return this.muslo;
    }
    
    public void setMuslo(float muslo) {
        this.muslo = muslo;
    }
    public Integer getIrm() {
        return this.irm;
    }
    
    public void setIrm(Integer irm) {
        this.irm = irm;
    }
    public Integer getGrasaCorporal() {
        return this.grasaCorporal;
    }
    
    public void setGrasaCorporal(Integer grasaCorporal) {
        this.grasaCorporal = grasaCorporal;
    }




}

