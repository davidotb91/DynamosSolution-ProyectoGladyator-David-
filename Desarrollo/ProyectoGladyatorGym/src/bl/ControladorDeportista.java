/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import dl.Deportista;
import dl.HibernateUtil;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Katherine
 */
public class ControladorDeportista {
   public void insertarDeportista( Deportista deportista)
    {
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        session.save(deportista);
        tx.commit();
        session.close();
        JOptionPane.showMessageDialog(null,"Insertado correctamente.");
    } 
   
    public DefaultListModel mostrarDeportistas()
    {
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Deportista d");
        List<Deportista> lista = q.list();
        Iterator<Deportista> iter=lista.iterator();
        tx.commit();
        session.close();
        DefaultListModel dlm = new DefaultListModel();
        while(iter.hasNext())
        {
            Deportista noti = (Deportista) iter.next();
            dlm.addElement(noti);
        }
        return dlm;
    }
    
     public DefaultListModel obtenerDatosDeportista(String cedula){
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from deportista d where deportista.cedula=" + cedula +"");
        List<Deportista> lista = q.list();
        Iterator<Deportista> iter=lista.iterator();
        tx.commit();
        session.close();
        DefaultListModel dlm = new DefaultListModel();
        while(iter.hasNext())
        {
            Deportista noti = (Deportista) iter.next();
           
            dlm.addElement(noti);
        }
        return dlm;
     }

//        public DefaultListModel mostrarNoticias()
//    {
//        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
//        Session session = sesion.openSession();
//        Transaction tx = session.beginTransaction();
//        Query q = session.createQuery("from Noticias");
//        List<Noticias> lista = q.list();
//        Iterator<Noticias> iter=lista.iterator();
//        tx.commit();
//        session.close();
//        DefaultListModel dlm = new DefaultListModel();
//        while(iter.hasNext())
//        {
//            Noticias noti = (Noticias) iter.next();
//            dlm.addElement(noti);
//        }
//        return dlm;
//    }    
    
    
}
