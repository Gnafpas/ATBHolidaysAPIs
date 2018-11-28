package DAOs.ViatorDBDAOs;

import Beans.ViatorDBBeans.ViatorProductAdditionalInfoBean;
import DBConnection.HibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import static Controller.Application.errLogger;

/**
 * Created by George on 23/06/17.
 */
public class ViatorProductAdditionalInfoDAO {

    public static boolean addproductadditionalinfo(ViatorProductAdditionalInfoBean viatorproductadditionalinfoBean,StatelessSession session){

        boolean err=false;
        try{
            session.insert(viatorproductadditionalinfoBean);
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
        }
        return err;
    }

    public static boolean deleteProductAdditionalInfo(String productCode){

        StatelessSession session = HibernateUtil.getSession();
        String hql = String.format("DELETE FROM ViatorProductAdditionalInfoBean WHERE productCode='"+productCode+"'");
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

    public static List<ViatorProductAdditionalInfoBean> getAdditionalInfoByProductCode(String productCode){

        StatelessSession session = HibernateUtil.getSession();List<ViatorProductAdditionalInfoBean> additionalInfo=null;
        String hql ="Select additionalInfo FROM ViatorProductAdditionalInfoBean additionalInfo " +
                                          "WHERE additionalInfo.productCode like :productCode ";
        try{
            session.beginTransaction();
            additionalInfo=session.createQuery(hql).setParameter("productCode",   productCode ).getResultList();
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
        return additionalInfo;
    }
}
