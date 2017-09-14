package DAOs.DBDAOs;

import DBBeans.ViatorUpdateFailedAvailDatesBean;
import DBConnection.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by George on 08/07/2017.
 */
public class ViatorUpdateFailedAvailDatesDAO {

    public static boolean addViatorUpdateFailedAvailDates(ViatorUpdateFailedAvailDatesBean viatorUpdateFailedAvailDatesBean){

        Session session = HibernateUtil.getSession();
        Transaction tx;
        boolean err=false;
        try{
            tx=session.beginTransaction();
            session.save(viatorUpdateFailedAvailDatesBean);
            tx.commit();
            session.close();
        }catch (HibernateException e) {
            err=true;
            e.printStackTrace();
            session.close();
        }catch (ExceptionInInitializerError e) {
            err=true;
            e.printStackTrace();
        }
        return err;
    }
}
