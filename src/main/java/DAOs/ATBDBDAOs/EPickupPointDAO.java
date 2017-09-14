package DAOs.ATBDBDAOs;

import ATBDBBeans.EPickupPointBean;
import DBConnection.ATBHibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by George on 18/08/2017.
 */
public class EPickupPointDAO {
    public static boolean addPickupPoint(List<EPickupPointBean> pickupPoints){

        StatelessSession session = ATBHibernateUtil.getSession();
        Transaction tx;
        boolean err=false;
        try{
            tx=session.beginTransaction();
            for(EPickupPointBean pickupPoint:pickupPoints)
                session.insert(pickupPoint);
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

    public static boolean deletePickupPoint(String code){

        StatelessSession session = ATBHibernateUtil.getSession();
        String hql = String.format("DELETE FROM EPickupPointBean WHERE productId='"+code+"'");
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
