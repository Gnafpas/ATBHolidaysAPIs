package DAOs.ATBDBDAOs;

import ATBDBBeans.FPricePlanBean;
import DBConnection.ATBHibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 * Created by George on 20/08/2017.
 */
public class FPricePlanDAO {

    public static boolean addPriceplan(FPricePlanBean pricePlanBean){

        StatelessSession session = ATBHibernateUtil.getSession();
        Transaction tx;
        boolean err=false;
        try{
            session = ATBHibernateUtil.getSession();
            tx=session.beginTransaction();
            session.insert(pricePlanBean);
            tx.commit();
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

    public static boolean deletePriceplan(String code){

        StatelessSession session = ATBHibernateUtil.getSession();
        String hql = String.format("DELETE FROM FPricePlanBean WHERE productId='"+code+"'");
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

    public static FPricePlanBean getLastRecord(){

        StatelessSession session = ATBHibernateUtil.getSession();
        String hql=     " select  a"
                      + " from ATBDBBeans.FPricePlanBean a"
                      + " order by a.id DESC";
        FPricePlanBean pricePlanBean=null;
        try{
            Query query= session.createQuery(hql);
            query.setMaxResults(1);
            pricePlanBean=(FPricePlanBean)query.getSingleResult();
            session.close();
        }catch (HibernateException e) {
            e.printStackTrace();
            session.close();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }catch (NoResultException  e) {
            e.printStackTrace();
            session.close();
        }

        return pricePlanBean;
    }
}
