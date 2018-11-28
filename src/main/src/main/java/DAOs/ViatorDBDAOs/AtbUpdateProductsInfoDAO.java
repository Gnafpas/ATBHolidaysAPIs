package DAOs.ViatorDBDAOs;

import Beans.ViatorDBBeans.AtbUpdateProductsInfoBean;
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
 * Created by George on 03/10/2017.
 */
public class AtbUpdateProductsInfoDAO {

    public static boolean addATBUpdateProductsInfo(AtbUpdateProductsInfoBean atbUpdateProductsInfoBean){

        StatelessSession session = HibernateUtil.getSession();
        Transaction tx;
        boolean err=false;
        try{
            tx=session.beginTransaction();
            session.insert(atbUpdateProductsInfoBean);
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

    public static AtbUpdateProductsInfoBean getLastRecord(){

        StatelessSession session = HibernateUtil.getSession();
        String hql=     " select  updateInfo"
                      + " from Beans.ViatorDBBeans.AtbUpdateProductsInfoBean updateInfo"
                      + " order by updateInfo.rid DESC";
        AtbUpdateProductsInfoBean atbUpdateProductsInfoBean=null;
        try{
            Query query= session.createQuery(hql);
            query.setMaxResults(1);
            atbUpdateProductsInfoBean=(AtbUpdateProductsInfoBean)query.getSingleResult();
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
        return atbUpdateProductsInfoBean;
    }
}
