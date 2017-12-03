package DAOs.ViatorDBDAOs;

import Beans.ViatorDBBeans.ViatorDestinationsBean;
import DBConnection.HibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import static Controller.Application.errLogger;

/**
 * Created by George on 23/06/17.
 */
public class ViatorDestinationsDAO {


    public static boolean adddestination(ViatorDestinationsBean viatordestinationsBean){

        Session session = HibernateUtil.getSession();
        Transaction tx;
        boolean err=false;
        try{

            tx=session.beginTransaction();
            session.save(viatordestinationsBean);
            tx.commit();
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
        }finally {
            session.close();
        }
        return err;
    }

    public static boolean deleteDestination(int destId){

        Session session = HibernateUtil.getSession();
        String hql = String.format("DELETE FROM ViatorDestinationsBean WHERE destinationId='"+destId+"'");
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
        }catch (CJCommunicationsException e){
            err=true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }finally {
            session.close();
        }
        return err;
    }

    public static List<ViatorDestinationsBean> getDestinationsByName(String destName) {
        List<ViatorDestinationsBean> destinations = null;
        Session session = HibernateUtil.getSession();
        String hql = " select DISTINCT(i) "
                + " from Beans.ViatorDBBeans.ViatorDestinationsBean i "
                + " where i.destinationNameEn LIKE :destName";
        try {
            destinations = session.createQuery(hql)
                    .setParameter("destName", "%" + destName + "%").list();
        } catch (HibernateException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        } catch (ExceptionInInitializerError e) {
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

        return destinations;
    }


    public static ViatorDestinationsBean getDestinationsByDestinationId(int destId) {
        ViatorDestinationsBean destination = null;
        Session session = HibernateUtil.getSession();
        String hql = " select i "
                + " from Beans.ViatorDBBeans.ViatorDestinationsBean i "
                + " where i.destinationId = :destId";
        try {
            destination =(ViatorDestinationsBean) session.createQuery(hql)
                    .setParameter("destId", destId).getSingleResult();
        } catch (HibernateException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        } catch (ExceptionInInitializerError e) {
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

        return destination;
    }

    public static List<ViatorDestinationsBean> getAllDestinations() {
        List<ViatorDestinationsBean> destinations = null;
        Session session = HibernateUtil.getSession();
        String hql = " select DISTINCT(i) "
                   + " from Beans.ViatorDBBeans.ViatorDestinationsBean i ";
        try {
            destinations = session.createQuery(hql) .list();
        } catch (HibernateException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        } catch (ExceptionInInitializerError e) {
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

        return destinations;
    }



}
