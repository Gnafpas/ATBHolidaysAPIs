package DAOs.ViatorDBDAOs;

import Beans.ViatorDBBeans.ViatorPickupHotelsBean;
import DBConnection.HibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import static Controller.Application.errLogger;

/**
 * Created by George on 12/07/2017.
 */
public class ViatorPickupHotelsDAO {

    public static  boolean addPickupHotel(ViatorPickupHotelsBean viatorPickupHotelsBean,StatelessSession session){

        boolean err=false;
        try{
            session.insert(viatorPickupHotelsBean);
        }catch (HibernateException e) {
            err=true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ExceptionInInitializerError e) {
            err=true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (CJCommunicationsException e){
            err=true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }
        return err;
    }


    public static boolean deleteProductPickupHotels(String productCode){

        StatelessSession session = HibernateUtil.getSession();
        String hql = String.format("DELETE FROM ViatorPickupHotelsBean WHERE productCode='"+productCode+"'");
        boolean err=false;
        try{
            session.beginTransaction();
            session.createQuery(hql).executeUpdate();
            session.getTransaction().commit();
        }catch (HibernateException e) {
            err=true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ExceptionInInitializerError e) {
            err=true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }finally {
            session.close();
        }
        return err;
    }

    public static List<ViatorPickupHotelsBean> getPickupHotelsByProductCode(String productCode){

        StatelessSession session = HibernateUtil.getSession();
        List<ViatorPickupHotelsBean> pickupHotelsBean=null;
        String hql ="Select pickupHotels FROM ViatorPickupHotelsBean pickupHotels " +
                                        "WHERE pickupHotels.productCode like :productCode " +
                                        "order by pickupHotels.sortOrder " ;
        try{
            session.beginTransaction();
            pickupHotelsBean=session.createQuery(hql).setParameter("productCode",   productCode ).getResultList();
            session.getTransaction().commit();
        }catch (HibernateException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ExceptionInInitializerError e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (CJCommunicationsException e){
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }finally {
            session.close();
        }
        return pickupHotelsBean;
    }
}
