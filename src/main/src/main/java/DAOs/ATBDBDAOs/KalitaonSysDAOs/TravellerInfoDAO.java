package DAOs.ATBDBDAOs.KalitaonSysDAOs;

import Beans.ATBDBBeans.KalitaonSystem.TravellerInfoBean;
import DBConnection.ATBSysHibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import com.sun.xml.internal.ws.client.ClientTransportException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import static Controller.Application.errLogger;

/**
 * Created by George on 01/02/2018.
 */
public class TravellerInfoDAO {

    public static boolean storeTraveler(TravellerInfoBean travellerInfoBean){

        boolean error=false;
        Session session = ATBSysHibernateUtil.getSession();
        try{
            session.beginTransaction();
            session.save(travellerInfoBean);
            session.getTransaction().commit();
        }catch (HibernateException e) {
            error=true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ExceptionInInitializerError e) {
            error=true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        } catch (ClientTransportException e) {
            error=true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (CJCommunicationsException e){
            error=true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (NoResultException e) {

        }finally{
            session.close();
        }
        return error;
    }

    public static List<TravellerInfoBean> getTravellerInfoBeanByBookingId(String bookingId){

        Session session = ATBSysHibernateUtil.getSession();
        List<TravellerInfoBean> travellerInfoBean=null;
        String hql = "select travellerInfoBean from TravellerInfoBean travellerInfoBean " +
                "where travellerInfoBean.bookingId ='"+bookingId+"'";
        try{
            session.beginTransaction();
            travellerInfoBean=session.createQuery(hql).getResultList();
        }catch (HibernateException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ExceptionInInitializerError e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (NoResultException e) {
        }catch (CJCommunicationsException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return travellerInfoBean;
    }
}
