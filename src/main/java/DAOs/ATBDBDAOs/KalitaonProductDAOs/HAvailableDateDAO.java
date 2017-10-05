package DAOs.ATBDBDAOs.KalitaonProductDAOs;

import Beans.ATBDBBeans.KalitaonProduct.HAvailableDateBean;
import DBConnection.ATBHibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import org.hibernate.HibernateException;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

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
        } catch (ExceptionInInitializerError e) {
            err = true;
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            err=true;
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
        }catch (ExceptionInInitializerError e) {
            err=true;
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            err=true;
            e.printStackTrace();
        }
        return err;
    }

    public static HAvailableDateBean getLastRecord(){
        StatelessSession session = ATBHibernateUtil.getSession();
        String hql=     " select  a"
                + " from HAvailableDateBean a"
                + " order by a.id DESC";
        HAvailableDateBean product=null;
        try{
            Query query= session.createQuery(hql);
            query.setMaxResults(1);
            product=(HAvailableDateBean)query.getSingleResult();
            session.close();
        }catch (HibernateException e) {
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }catch (NoResultException e) {
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            e.printStackTrace();
        }

        return product;
    }

    public static List<HAvailableDateBean> gethAvailableDatesByProductId(String productId){

        StatelessSession session = ATBHibernateUtil.getSession();
        List<HAvailableDateBean> hAvailableDates=null;
        String hql ="Select hAvailableDates FROM HAvailableDateBean hAvailableDates " +
                "WHERE hAvailableDates.productId like :productId ";
        try{
            session.beginTransaction();
            hAvailableDates=session.createQuery(hql).setParameter("productId",   productId ).getResultList();
            session.getTransaction().commit();
            session.close();
        }catch (HibernateException e) {
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            e.printStackTrace();
        }
        return hAvailableDates;
    }
}
