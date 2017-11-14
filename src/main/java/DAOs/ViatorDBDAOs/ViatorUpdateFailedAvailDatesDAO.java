package DAOs.ViatorDBDAOs;

import Beans.ViatorDBBeans.ViatorUpdateFailedAvailDatesBean;
import DBConnection.HibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

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

    public static List<String> getProductCodeByUpdateRid(int updateRid){

        Session session = HibernateUtil.getSession();
        List<String> failedProductCodes=null;
        String hql ="Select failedProducts.productWithFailedAvailDates FROM ViatorUpdateFailedAvailDatesBean failedProducts " +
                "WHERE failedProducts.updateRid = :updateRid ";
        try{
            session.beginTransaction();
            failedProductCodes=session.createQuery(hql).setParameter("updateRid", updateRid).getResultList();
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
        return failedProductCodes;
    }
}
