package DAOs.DBDAOs;

import DBBeans.ViatorPickupHotelsBean;
import DBConnection.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by George on 12/07/2017.
 */
public class ViatorPickupHotelsDAO {

    public static  boolean addPickupHotel(ViatorPickupHotelsBean viatorPickupHotelsBean){

        Session session = HibernateUtil.getSession();
        Transaction tx;
        boolean err=false;
        try{
            tx=session.beginTransaction();
            session.save(viatorPickupHotelsBean);
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


    public static boolean deleteProductPickupHotels(String productCode){

        Session session = HibernateUtil.getSession();
        String hql = String.format("DELETE FROM ViatorPickupHotelsBean WHERE productCode='"+productCode+"'");
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

    public static List<ViatorPickupHotelsBean> getPickupHotelsByProductCode(String productCode){

        Session session = HibernateUtil.getSession();
        List<ViatorPickupHotelsBean> pickupHotelsBean=null;
        String hql ="Select pickupHotels FROM ViatorPickupHotelsBean pickupHotels " +
                                        "WHERE pickupHotels.productCode like :productCode " +
                                        "order by pickupHotels.sortOrder " ;
        try{
            session.beginTransaction();
            pickupHotelsBean=session.createQuery(hql).setParameter("productCode",   productCode ).getResultList();
            session.getTransaction().commit();
            session.close();
        }catch (HibernateException e) {
            e.printStackTrace();
            session.close();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }
        return pickupHotelsBean;
    }
}
