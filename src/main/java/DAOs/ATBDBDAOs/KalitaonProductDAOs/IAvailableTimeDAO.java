package DAOs.ATBDBDAOs.KalitaonProductDAOs;

import Beans.ATBDBBeans.KalitaonProduct.IAvailableTimeBean;
import DBConnection.ATBHibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import org.hibernate.HibernateException;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

import java.util.List;

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
        } catch (HibernateException e) {
            err = true;
            e.printStackTrace();
        } catch (ExceptionInInitializerError e) {
            err = true;
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            err=true;
            e.printStackTrace();
        }finally {
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
        }catch (HibernateException e) {
            err=true;
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            err=true;
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            err=true;
            e.printStackTrace();
        }finally {
            session.close();
        }
        return err;
    }

    public static List<IAvailableTimeBean> getiAvailableTimesByProductId(String productId,String planId){

        StatelessSession session = ATBHibernateUtil.getSession();
        List<IAvailableTimeBean> iAvailableTimes=null;
        String hql ="Select iAvailableTimes FROM IAvailableTimeBean iAvailableTimes " +
                "WHERE iAvailableTimes.productId like :productId"+
                " AND   iAvailableTimes.planId like :planId";
        try{
            session.beginTransaction();
            iAvailableTimes=session.createQuery(hql).setParameter("productId",   productId )
                    .setParameter("planId",   "%"+planId+"%" )
                    .getResultList();
            session.getTransaction().commit();
        }catch (HibernateException e) {
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return iAvailableTimes;
    }
}
