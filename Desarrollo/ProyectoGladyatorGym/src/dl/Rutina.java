package dl;
// Generated 19/10/2016 17:26:37 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Rutina generated by hbm2java
 */
public class Rutina  implements java.io.Serializable {


     private Integer idRutina;
     private Acceso acceso;
     private Planificacion planificacion;
     private int numeroDia;
     private Set accesos = new HashSet(0);
     private Set musculos = new HashSet(0);

    public Rutina() {
    }

	
    public Rutina(int numeroDia) {
        this.numeroDia = numeroDia;
    }
    public Rutina(Acceso acceso, Planificacion planificacion, int numeroDia, Set accesos, Set musculos) {
       this.acceso = acceso;
       this.planificacion = planificacion;
       this.numeroDia = numeroDia;
       this.accesos = accesos;
       this.musculos = musculos;
    }
   
    public Integer getIdRutina() {
        return this.idRutina;
    }
    
    public void setIdRutina(Integer idRutina) {
        this.idRutina = idRutina;
    }
    public Acceso getAcceso() {
        return this.acceso;
    }
    
    public void setAcceso(Acceso acceso) {
        this.acceso = acceso;
    }
    public Planificacion getPlanificacion() {
        return this.planificacion;
    }
    
    public void setPlanificacion(Planificacion planificacion) {
        this.planificacion = planificacion;
    }
    public int getNumeroDia() {
        return this.numeroDia;
    }
    
    public void setNumeroDia(int numeroDia) {
        this.numeroDia = numeroDia;
    }
    public Set getAccesos() {
        return this.accesos;
    }
    
    public void setAccesos(Set accesos) {
        this.accesos = accesos;
    }
    public Set getMusculos() {
        return this.musculos;
    }
    
    public void setMusculos(Set musculos) {
        this.musculos = musculos;
    }




}


