package DAOs.ATBDBDAOs.KalitaonHotelDAOs;

import Beans.ATBDBBeans.KalitaonHotel.FacilityBean;
import DBConnection.SunHotelsHibernateUtil;
import DBConnection.SunHotelsMainServerHibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import com.sun.xml.internal.ws.client.ClientTransportException;
import org.hibernate.HibernateException;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import static Controller.Application.errLogger;
import static Helper.ProjectProperties.sanHotelsProviderId;

/**
 * Created by George on 23/11/2017.
 */
public class FacilityDAO {

    public static boolean addFacilityBean(FacilityBean facilityBean, StatelessSession session,StatelessSession session2){

        boolean err=false;
        try{
            session.insert(facilityBean);
            session2.insert(facilityBean);
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
        }catch (ClientTransportException e) {
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

    public static boolean updateFacilityBean(FacilityBean facilityBean, StatelessSession session,StatelessSession session2){

        boolean err=false;
        try{
            session.update(facilityBean);
            session2.update(facilityBean);
        }catch (HibernateException e) {
            err=true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ExceptionInInitializerError e) {
            err = true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        } catch (ClientTransportException e) {
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

    public static boolean deleteAllFacilities(int providerId){

        StatelessSession session = SunHotelsHibernateUtil.getSession();
        StatelessSession session2 = SunHotelsMainServerHibernateUtil.getSession();
        String hql = String.format("DELETE FROM FacilityBean WHERE providerId='"+providerId+"'");
        boolean err=false;
        try{
            session.beginTransaction();
            session.createQuery(hql).executeUpdate();
            session.getTransaction().commit();
            session2.beginTransaction();
            session2.createQuery(hql).executeUpdate();
            session2.getTransaction().commit();
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
        }catch (ClientTransportException e) {
            err=true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (CJCommunicationsException e){
            err=true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }finally {
            session.close();
            session2.close();
        }
        return err;
    }

    public static List<FacilityBean> getFacilities(int providerId){

        StatelessSession session = SunHotelsHibernateUtil.getSession();
        List<FacilityBean> facilities=null;
        String hql = "select facility from FacilityBean facility where  facility.providerId='"+providerId+"'";
        try{
            session.beginTransaction();
            facilities=session.createQuery(hql).list();
        }catch (HibernateException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ExceptionInInitializerError e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ClientTransportException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (CJCommunicationsException e){
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (NoResultException e){

        }finally {
            session.close();
        }
        return facilities;
    }

    public static FacilityBean getFacilityByFacilityId(String facilityId, int providerId, StatelessSession session) {

        boolean incomingSession = true;
        FacilityBean facilityBean = null;
        String hql = "select facilityBean from FacilityBean facilityBean where  facilityBean.facilityId='" + facilityId + "' and facilityBean.providerId='" + providerId + "'";
        try {
            if (session == null) {
                session = SunHotelsHibernateUtil.getSession();
                session.beginTransaction();
                incomingSession = false;
            }
            facilityBean = (FacilityBean)session.createQuery(hql).getSingleResult();
        } catch (HibernateException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        } catch (ExceptionInInitializerError e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        } catch (ClientTransportException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        } catch (CJCommunicationsException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        } catch (NoResultException e) {

        } finally {
            if (!incomingSession)
                session.close();
        }
        return facilityBean;
    }
}
