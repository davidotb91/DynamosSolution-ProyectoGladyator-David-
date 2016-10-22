/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import dl.HibernateUtil;
import dl.Impedimentos;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author desarrolloPC
 */
public class ControladorImpedimentos {
    public void insertarPago( Impedimentos impedimentos)
    {
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        session.save(impedimentos);
        tx.commit();
        session.close();
    } 
    
    
}
