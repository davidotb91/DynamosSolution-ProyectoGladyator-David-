/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import dl.Deportista;
import dl.HibernateUtil;
import dl.Pago;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultListModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Katherine
 */
public class ControladorPago {
    
  public List <Pago> mostrarPago()
    {
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Pago p");
        List<Pago> lista = q.list();
        Iterator<Pago> iter=lista.iterator();
        tx.commit();
        session.close();
        DefaultListModel dlm = new DefaultListModel();
       
        while(iter.hasNext())
        {
             
            Pago noti = (Pago) iter.next();
            
            dlm.addElement(noti);
           
        }
          System.out.println("Elementos en BDD: "+lista.size());
           
        return lista;
        
    }
  
  public void insertarPago( Pago pago)
    {
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        session.save(pago);
        tx.commit();
        session.close();
    } 
    
}
