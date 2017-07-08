package DAOs.DBDAOs;

import DBBeans.ViatorAvailabilityDatesBean;
import DBBeans.ViatorCategoriesBean;
import DBConnection.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by George on 07/07/2017.
 */
public class ViatorAvailabilityDatesDAO {

    private HibernateUtil helper;
    private Session session;

    public boolean addAvailabilityDate(ViatorAvailabilityDatesBean availabilityDatesBean){

        Transaction tx;
        boolean err=false;
        try{
            session = helper.getSession();
            tx=session.beginTransaction();
            session.save(availabilityDatesBean);
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

    public boolean deleteProductAvailDates(String productCode){

        String hql = String.format("delete from ViatorAvailabilityDatesBean WHERE productCode='"+productCode+"'");
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
}
