package DAOs.ATBDBDAOs.KalitaonHotelDAOs;

import Beans.ATBDBBeans.KalitaonHotel.AccommodationsBean;
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

/**
 * Created by George on 10/03/2018.
 */
public class AccommodationsDAO {

    public static boolean addAccommodationsBean(AccommodationsBean accommodationsBean, StatelessSession session,StatelessSession session2){

        boolean err=false;
        try{
            session.insert(accommodationsBean);
            session2.insert(accommodationsBean);
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

    public static boolean updateAccommodationsBean(AccommodationsBean accommodationsBean, StatelessSession session,StatelessSession session2){

        boolean err=false;
        try{
            session.update(accommodationsBean);
            session2.update(accommodationsBean);
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

    public static AccommodationsBean getAccommodationByAccommodationId(String accommodationId, int providerId, StatelessSession session) {

        boolean incomingSession = true;
        AccommodationsBean accommodationsBean = null;
        String hql = "select accommodation from AccommodationsBean accommodation where  accommodation.accommodationId='" + accommodationId + "' and accommodation.providerId='" + providerId + "'";
        try {
            if (session == null) {
                session = SunHotelsHibernateUtil.getSession();
                session.beginTransaction();
                incomingSession = false;
            }
            accommodationsBean = (AccommodationsBean)session.createQuery(hql).getSingleResult();
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
        return accommodationsBean;
    }

    public static List<AccommodationsBean> getAccommodationByproviderId( int providerId, StatelessSession session) {

        boolean incomingSession = true;
        List<AccommodationsBean> accommodationsBean = null;
        String hql = "select accommodation from AccommodationsBean accommodation where   accommodation.providerId='" + providerId + "'";
        try {
            if (session == null) {
                session = SunHotelsHibernateUtil.getSession();
                session.beginTransaction();
                incomingSession = false;
            }
            accommodationsBean = session.createQuery(hql).getResultList();
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
        return accommodationsBean;
    }
}
