package DAOs.ATBDBDAOs;

import ATBDBBeans.HAvailableDateBean;
import DBConnection.ATBHibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 * Created by George on 25/08/2017.
 */
public class HAvailableDateDAO {

    public static boolean addAvailableDate(HAvailableDateBean availableDate) {
        StatelessSession session = ATBHibernateUtil.getSession();
        Transaction tx;
        boolean err = false;
        try {
            session = ATBHibernateUtil.getSession();
            tx = session.beginTransaction();
            session.insert(availableDate);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            err = true;
            e.printStackTrace();
            session.close();
        } catch (ExceptionInInitializerError e) {
            err = true;
            e.printStackTrace();
        }
        return err;

    }

    public static boolean deleteAvailableDate(String code){

        StatelessSession session = ATBHibernateUtil.getSession();
        String hql = String.format("DELETE FROM HAvailableDateBean WHERE productId='"+code+"'");
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
        }
        return err;
    }

    public static HAvailableDateBean getLastRecord(){
        StatelessSession session = ATBHibernateUtil.getSession();
        String hql=     " select  a"
                + " from ATBDBBeans.HAvailableDateBean a"
                + " order by a.id DESC";
        HAvailableDateBean product=null;
        try{
            Query query= session.createQuery(hql);
            query.setMaxResults(1);
            product=(HAvailableDateBean)query.getSingleResult();
            session.close();
        }catch (HibernateException e) {
            e.printStackTrace();
            session.close();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }catch (NoResultException e) {
            e.printStackTrace();
            session.close();
        }

        return product;
    }
}
