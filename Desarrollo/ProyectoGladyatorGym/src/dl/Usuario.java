package dl;
// Generated 19/10/2016 17:26:37 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private Integer idUsuario;
     private Perfil perfil;
     private String usuario;
     private String contrasena;
     private Set accesos = new HashSet(0);

    public Usuario() {
    }

	
    public Usuario(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }
    public Usuario(Perfil perfil, String usuario, String contrasena, Set accesos) {
       this.perfil = perfil;
       this.usuario = usuario;
       this.contrasena = contrasena;
       this.accesos = accesos;
    }
   
    public Integer getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    public Perfil getPerfil() {
        return this.perfil;
    }
    
    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    public String getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getContrasena() {
        return this.contrasena;
    }
    
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public Set getAccesos() {
        return this.accesos;
    }
    
    public void setAccesos(Set accesos) {
        this.accesos = accesos;
    }




}

