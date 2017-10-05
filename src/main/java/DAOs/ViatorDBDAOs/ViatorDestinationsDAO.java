package DAOs.ViatorDBDAOs;

import Beans.ViatorDBBeans.ViatorDestinationsBean;
import DBConnection.HibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

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
            session.close();
        }catch (HibernateException e) {
            err=true;
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            err=true;
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            err=true;
            e.printStackTrace();
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
            session.close();
        }catch (HibernateException e) {
            err=true;
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            err=true;
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            err=true;
            e.printStackTrace();
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
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        } catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            e.printStackTrace();
        }

        return destinations;
    }

    public static List<ViatorDestinationsBean> getAllDestinations() {
        List<ViatorDestinationsBean> destinations = null;
        Session session = HibernateUtil.getSession();
        String hql = " select DISTINCT(i) "
                   + " from Beans.ViatorDBBeans.ViatorDestinationsBean i ";
        try {
            destinations = session.createQuery(hql) .list();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        } catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            e.printStackTrace();
        }

        return destinations;
    }



}
