package DAOs.ViatorDBDAOs;

import Beans.ViatorDBBeans.ViatorPricingMatrixBean;
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
 * Created by George on 19/08/2017.
 */
public class ViatorPricingMatrixDAO {

    public static  boolean addPricingMatrix(ViatorPricingMatrixBean viatorPricingMatrixBean,StatelessSession session){

        boolean err=false;
        try{
            session.insert(viatorPricingMatrixBean);
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

    public static boolean deletePricingMatrixes(String productCode){

        StatelessSession session = HibernateUtil.getSession();
        String hql = String.format("DELETE FROM ViatorPricingMatrixBean WHERE productCode='"+productCode+"'");
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
        }finally {
            session.close();
        }
        return err;
    }

    public static List<ViatorPricingMatrixBean> getPricingMatrixByProductCode(String productCode){

        StatelessSession session = HibernateUtil.getSession();
        List<ViatorPricingMatrixBean> pricingMatrixBean=null;
        String hql ="Select pricingMatrix FROM ViatorPricingMatrixBean pricingMatrix " +
                "WHERE pricingMatrix.productCode like :productCode " +
                "order by pricingMatrix.sortOrderOfDate," +
                         "pricingMatrix.sortOrderOfTourGrade," +
                         "pricingMatrix.sortOrderOfPricing," +
                         "pricingMatrix.sortOrderOfAgeBand," +
                         "pricingMatrix.sortOrderOfPrice " ;
        try{
            session.beginTransaction();
            pricingMatrixBean=session.createQuery(hql).setParameter("productCode",   productCode ).getResultList();
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
        return pricingMatrixBean;
    }
}
