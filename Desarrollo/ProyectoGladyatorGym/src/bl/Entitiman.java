/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author desarrolloPC
 */
public  final class Entitiman {
    private static  EntityManagerFactory emf= Persistence.createEntityManagerFactory("ProyectoGladyatorGymPU");

    public Entitiman() {
    }
    public static EntityManagerFactory getinstance (){
        return emf;
    }
    
}
