package dl;
// Generated 24/10/2016 17:17:32 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Musculo generated by hbm2java
 */
public class Musculo  implements java.io.Serializable {


     private Integer idMusculo;
     private Rutina rutina;
     private String nombreMusculo;
     private Set ejercicios = new HashSet(0);

    public Musculo() {
    }

	
    public Musculo(String nombreMusculo) {
        this.nombreMusculo = nombreMusculo;
    }
    public Musculo(Rutina rutina, String nombreMusculo, Set ejercicios) {
       this.rutina = rutina;
       this.nombreMusculo = nombreMusculo;
       this.ejercicios = ejercicios;
    }
   
    public Integer getIdMusculo() {
        return this.idMusculo;
    }
    
    public void setIdMusculo(Integer idMusculo) {
        this.idMusculo = idMusculo;
    }
    public Rutina getRutina() {
        return this.rutina;
    }
    
    public void setRutina(Rutina rutina) {
        this.rutina = rutina;
    }
    public String getNombreMusculo() {
        return this.nombreMusculo;
    }
    
    public void setNombreMusculo(String nombreMusculo) {
        this.nombreMusculo = nombreMusculo;
    }
    public Set getEjercicios() {
        return this.ejercicios;
    }
    
    public void setEjercicios(Set ejercicios) {
        this.ejercicios = ejercicios;
    }




}


