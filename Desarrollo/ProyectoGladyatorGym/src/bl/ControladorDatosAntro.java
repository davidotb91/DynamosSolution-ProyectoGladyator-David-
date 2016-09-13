/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import dl.Deportista;
import dl.HibernateUtil;
import dl.MAntropometricas;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Katherine
 */
public class ControladorDatosAntro {
   public void insertarDatosAntropometricos( MAntropometricas medidas)
    {
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        session.save(medidas);
        tx.commit();
        session.close();
        JOptionPane.showMessageDialog(null,"Insertado correctamente.");
    } 
}
