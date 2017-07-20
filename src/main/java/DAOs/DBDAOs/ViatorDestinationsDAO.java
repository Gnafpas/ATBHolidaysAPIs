package DAOs.DBDAOs;

import DBBeans.ViatorDestinationsBean;
import DBBeans.ViatorProductDetailsBean;
import DBConnection.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by George on 23/06/17.
 */
public class ViatorDestinationsDAO {
    private HibernateUtil helper;
    private Session session;

    public boolean adddestination(ViatorDestinationsBean viatordestinationsBean){

        Transaction tx;
        boolean err=false;
        try{
            session = helper.getSession();
            tx=session.beginTransaction();
            session.save(viatordestinationsBean);
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

    public boolean deleteDestination(int destId){

        String hql = String.format("DELETE FROM ViatorDestinationsBean WHERE destinationId='"+destId+"'");
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

    public List<ViatorDestinationsBean> getDestinationsByName(String destName) {
        List<ViatorDestinationsBean> destinations = null;

        String hql = " select DISTINCT(i) "
                + " from DBBeans.ViatorDestinationsBean i "
                + " where i.destinationNameEn LIKE :destName";
        Transaction tx = null;
        try {
            session = helper.getSession();
            tx = session.beginTransaction();
            destinations = session.createQuery(hql)
                    .setParameter("destName", "%" + destName + "%").list();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.close();
        } catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }

        return destinations;
    }

    public List<ViatorDestinationsBean> getAllDestinations() {
        List<ViatorDestinationsBean> destinations = null;

        String hql = " select DISTINCT(i) "
                   + " from DBBeans.ViatorDestinationsBean i ";
        Transaction tx = null;
        try {
            session = helper.getSession();
            tx = session.beginTransaction();
            destinations = session.createQuery(hql) .list();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.close();
        } catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }

        return destinations;
    }



}
