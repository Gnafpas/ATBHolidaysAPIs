package DAOs.ViatorDBDAOs;

import Beans.ViatorDBBeans.ViatorUpdateProductsInfoBean;
import DBConnection.HibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

import javax.persistence.Query;

import java.io.PrintWriter;
import java.io.StringWriter;

import static Controller.Application.errLogger;

/**
 * Created by George on 08/07/2017.
 */
public class ViatorUpdateProductsInfoDAO {

    public static boolean addViatorUpdateProductsInfo(ViatorUpdateProductsInfoBean viatorUpdateProductsInfoBean){

        StatelessSession session = HibernateUtil.getSession();
        Transaction tx;
        boolean err=false;
        try{
            tx=session.beginTransaction();
            session.insert(viatorUpdateProductsInfoBean);
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

    public static ViatorUpdateProductsInfoBean getLastRecord(){

        StatelessSession session = HibernateUtil.getSession();
        String hql=     " select  updateInfo"
                + " from Beans.ViatorDBBeans.ViatorUpdateProductsInfoBean updateInfo"
                + " order by updateInfo.rid DESC";
        ViatorUpdateProductsInfoBean viatorUpdateProductsInfoBean=null;
        try{
            Query query= session.createQuery(hql);
            query.setMaxResults(1);
            viatorUpdateProductsInfoBean=(ViatorUpdateProductsInfoBean)query.getSingleResult();
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
        return viatorUpdateProductsInfoBean;
    }
}
