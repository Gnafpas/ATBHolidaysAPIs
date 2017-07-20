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
    private HibernateUtil helper;
    private Session session;

    public boolean addPickupHotel(ViatorPickupHotelsBean viatorPickupHotelsBean){

        Transaction tx;
        boolean err=false;
        try{
            session = helper.getSession();
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


    public boolean deleteProductPickupHotels(String productCode){

        String hql = String.format("DELETE FROM ViatorPickupHotelsBean WHERE productCode='"+productCode+"'");
        boolean err=false;
        try{
            session = helper.getSession();
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

    public List<ViatorPickupHotelsBean> getPickupHotelsByProductCode(String productCode){

        List<ViatorPickupHotelsBean> pickupHotelsBean=null;
        String hql ="Select pickupHotels FROM ViatorPickupHotelsBean pickupHotels " +
                                        "WHERE pickupHotels.productCode like :productCode " +
                                        "order by pickupHotels.sortOrder " ;
        try{
            session = helper.getSession();
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
