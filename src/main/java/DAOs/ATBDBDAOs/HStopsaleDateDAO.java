package DAOs.ATBDBDAOs;

import ATBDBBeans.HStopsaleDateBean;
import DBConnection.ATBHibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

/**
 * Created by George on 25/08/2017.
 */
public class HStopsaleDateDAO {

    public static boolean addStopsaleDate(HStopsaleDateBean stopsaleDateBean) {
        StatelessSession session = ATBHibernateUtil.getSession();
        Transaction tx;
        boolean err = false;
        try {
            tx = session.beginTransaction();
            session.insert(stopsaleDateBean);
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

    public static boolean deleteStopsaleDate(String code){

        StatelessSession session = ATBHibernateUtil.getSession();
        String hql = String.format("DELETE FROM HStopsaleDateBean WHERE productId='"+code+"'");
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
