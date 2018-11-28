package DAOs.ATBDBDAOs.KalitaonProductDAOs;

import Beans.ATBDBBeans.KalitaonProduct.HStopsaleDateBean;
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
 * Created by George on 25/08/2017.
 */
public class HStopsaleDateDAO {

    public static boolean addStopsaleDate(HStopsaleDateBean stopsaleDateBean) {
        StatelessSession session = ATBHibernateUtil.getSession();
        Transaction tx;
        boolean err = false;
        try {
            tx = session.beginTransaction();
            session.insert(stopsaleDateBean);
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

    public static boolean deleteStopsaleDate(String code){

        StatelessSession session = ATBHibernateUtil.getSession();
        String hql = String.format("DELETE FROM HStopsaleDateBean WHERE productId='"+code+"'");
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

    public static List<HStopsaleDateBean> gethStopsaleDatesByProductId(String productId,String planId){

        StatelessSession session = ATBHibernateUtil.getSession();
        List<HStopsaleDateBean> hStopsaleDates=null;
        String hql ="Select hStopsaleDates FROM HStopsaleDateBean hStopsaleDates " +
                "WHERE hStopsaleDates.productId like :productId"+
                " AND   hStopsaleDates.planId like :planId";
        try{
            session.beginTransaction();
            hStopsaleDates=session.createQuery(hql).setParameter("productId",   productId )
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
        return hStopsaleDates;
    }
}
