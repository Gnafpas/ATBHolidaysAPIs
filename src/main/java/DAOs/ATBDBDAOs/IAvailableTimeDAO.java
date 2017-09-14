package DAOs.ATBDBDAOs;

import ATBDBBeans.IAvailableTimeBean;
import DBConnection.ATBHibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

/**
 * Created by George on 08/09/2017.
 */
public class IAvailableTimeDAO {

    public static boolean addAvailableTime(IAvailableTimeBean availableTimeBean) {
        StatelessSession session = ATBHibernateUtil.getSession();
        Transaction tx;
        boolean err = false;
        try {
            tx = session.beginTransaction();
            session.insert(availableTimeBean);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            err = true;
            e.printStackTrace();
            session.close();
        } catch (ExceptionInInitializerError e) {
            err = true;
            e.printStackTrace();
            session.close();
        }
        return err;

    }

    public static boolean deleteavailableTime(String code){

        StatelessSession session = ATBHibernateUtil.getSession();
        String hql = String.format("DELETE FROM IAvailableTimeBean WHERE productId='"+code+"'");
        boolean err=false;
        try{
            session.beginTransaction();
            session.createQuery(hql).executeUpdate();
            session.getTransaction().commit();
            session.close();
        }catch (HibernateException e) {
            err=true;
            e.printStackTrace();
            session.close();
        }catch (ExceptionInInitializerError e) {
            err=true;
            e.printStackTrace();
            session.close();
        }
        return err;
    }
}
