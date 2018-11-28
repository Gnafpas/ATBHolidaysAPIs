package DAOs.ATBDBDAOs.KalitaonProductDAOs;

import Beans.ATBDBBeans.KalitaonProduct.HSpecialDateBean;
import DBConnection.ATBHibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import org.hibernate.HibernateException;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import static Controller.Application.errLogger;

/**
 * Created by George on 05/10/2017.
 */
public class HSpecialDateDAO {

    public static boolean addSpecialDate(HSpecialDateBean specialDate) {
        StatelessSession session = ATBHibernateUtil.getSession();
        Transaction tx;
        boolean err = false;
        try {
            tx = session.beginTransaction();
            session.insert(specialDate);
            tx.commit();
        } catch (HibernateException e) {
            err = true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        } catch (ExceptionInInitializerError e) {
            err = true;
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

    public static boolean deleteSpecialDate(String productId){

        StatelessSession session = ATBHibernateUtil.getSession();
        String hql = String.format("DELETE FROM HSpecialDateBean WHERE productId='"+productId+"'");
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

    public static List<HSpecialDateBean> getSpecialDatesByProductId(String productId,String planId){

        StatelessSession session = ATBHibernateUtil.getSession();
        List<HSpecialDateBean> specialDates=null;
        String hql ="Select specialDates FROM HSpecialDateBean specialDates " +
                "WHERE specialDates.productId like :productId"+
                " AND   specialDates.planId like :planId";
        try{
            session.beginTransaction();
            specialDates=session.createQuery(hql).setParameter("productId",   productId )
                    .setParameter("planId",   "%"+planId+"%" )
                    .getResultList();
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
        return specialDates;
    }
}
