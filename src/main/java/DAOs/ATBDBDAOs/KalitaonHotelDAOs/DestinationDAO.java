package DAOs.ATBDBDAOs.KalitaonHotelDAOs;

import Beans.ATBDBBeans.KalitaonHotel.DestinationBean;
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
 * Created by George on 24/11/2017.
 */
public class DestinationDAO {

    public static boolean addDestinationBean(DestinationBean destinationBean){

        StatelessSession session = SunHotelsHibernateUtil.getSession();
        StatelessSession session2 = SunHotelsMainServerHibernateUtil.getSession();
        Transaction tx;
        Transaction tx2;
        boolean err=false;
        try{
            tx=session.beginTransaction();
            session.insert(destinationBean);
            tx.commit();
            tx2=session2.beginTransaction();
            session2.insert(destinationBean);
            tx2.commit();
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
        }finally {
            session.close();
            session2.close();
        }
        return err;
    }

    public static boolean updateDestinationBean(DestinationBean destinationBean){

        StatelessSession session = SunHotelsHibernateUtil.getSession();
        StatelessSession session2 = SunHotelsMainServerHibernateUtil.getSession();
        Transaction tx;
        Transaction tx2;
        boolean err=false;
        try{
            tx=session.beginTransaction();
            session.update(destinationBean);
            tx.commit();
            tx2=session2.beginTransaction();
            session2.update(destinationBean);
            tx2.commit();
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
        }finally {
            session.close();
            session2.close();
        }
        return err;
    }

    public static boolean deleteDestinationBeanSunhotelsId(int destinationId){

        StatelessSession session = SunHotelsHibernateUtil.getSession();
        StatelessSession session2 = SunHotelsMainServerHibernateUtil.getSession();
        String hql = String.format("DELETE FROM DestinationBean WHERE destinationId='"+destinationId+"'");
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
        }finally {
            session.close();
            session2.close();
        }
        return err;
    }

    public static DestinationBean getDestinationBean(String destinationId,int providerId,StatelessSession session) {

        boolean incomingSession=true;
        DestinationBean destinationBean = null;
        String hql = "select dest from DestinationBean dest where dest.providerId='" + providerId + "' and dest.destinationId='" + destinationId + "'";
        try {
            if(session==null) {
                session = SunHotelsHibernateUtil.getSession();
                session.beginTransaction();
                incomingSession=false;
            }
            destinationBean = (DestinationBean) session.createQuery(hql).getSingleResult();
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
        }catch (NoResultException e){

        }finally {
            if(!incomingSession)
                session.close();
        }
        return destinationBean;
    }

    public static DestinationBean getDestinationBeanByATBId(String atbId) {

        StatelessSession session;
        session = SunHotelsHibernateUtil.getSession();
        DestinationBean destinationBean = null;
        String hql = "select dest from DestinationBean dest where dest.id='" + atbId + "'";
        try {
            session.beginTransaction();
            destinationBean = (DestinationBean) session.createQuery(hql).getSingleResult();
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
        }catch (NoResultException e){

        }finally {
            session.close();
        }
        return destinationBean;
    }

    public static int getOriginalSunhotelsDestinationId(String atbDestinationId) {

        StatelessSession session;
        session = SunHotelsHibernateUtil.getSession();
        int originalDstinationId = 0;
        String hql = "select dest.destinationId from DestinationBean dest where dest.id='" + atbDestinationId + "'";
        try {
            session.beginTransaction();
            originalDstinationId = (int) session.createQuery(hql).getSingleResult();
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
        }catch (NoResultException e){

        }finally {
            session.close();
        }
        return originalDstinationId;
    }

    public static List<DestinationBean> getAllDestinations() {

        StatelessSession session;
        session = SunHotelsHibernateUtil.getSession();
        List<DestinationBean> destinations = null;
        String hql = "select dest from DestinationBean dest ";
        try {
            session.beginTransaction();
            destinations =  session.createQuery(hql).list();
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
        }catch (NoResultException e){

        }finally {
            session.close();
        }
        return destinations;
    }

    public static int increaseSortOrderOfDestination(String destId) {
        StatelessSession session;
        session = SunHotelsHibernateUtil.getSession();
        Transaction tx;
        int result=0;
        List<DestinationBean> destinations = null;
        String hql = "UPDATE DestinationBean SET sortOrder = sortOrder + 1 WHERE  id='"+destId+"'";
        try {
            tx=session.beginTransaction();
            result=session.createQuery(hql).executeUpdate();
            tx.commit();
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
        }catch (NoResultException e){

        }finally {
            session.close();
        }
        return result;

    }


}
