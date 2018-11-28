package DAOs.ViatorDBDAOs;

import Beans.ViatorDBBeans.ViatorNoneAvailableDatesBean;
import Beans.ViatorDBBeans.ViatorProductDetailsBean;
import DBConnection.HibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;
import javax.persistence.Query;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import static Controller.Application.errLogger;

/**
 * Created by George on 07/07/2017.
 */
public class ViatorNoneAvailableDatesDAO {

    public static boolean addNoneAvailabilityDate(ViatorNoneAvailableDatesBean availabilityDatesBean,StatelessSession session){

        boolean err=false;
        try{
            session.insert(availabilityDatesBean);
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

    public static boolean deleteProductNoneAvailDates(String productCode){

        StatelessSession session = HibernateUtil.getSession();
        String hql = String.format("delete from ViatorNoneAvailableDatesBean WHERE productCode='"+productCode+"'");
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

    public static List<ViatorNoneAvailableDatesBean> getNoneAvailableDatesBeanByProductCode(String productCode){

        StatelessSession session = HibernateUtil.getSession();
        List<ViatorNoneAvailableDatesBean> noneAvailableDatesBean=null;
        String hql ="Select noneAvailDates FROM ViatorNoneAvailableDatesBean noneAvailDates " +
                "WHERE noneAvailDates.productCode like :productCode " ;
        try{
            session.beginTransaction();
            noneAvailableDatesBean=session.createQuery(hql).setParameter("productCode",   productCode ).getResultList();
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
        return noneAvailableDatesBean;
    }

    public static List<ViatorNoneAvailableDatesBean> getNoneAvailDatesOfProducts(List<ViatorProductDetailsBean> productsDetails){

        StatelessSession session = HibernateUtil.getSession();
        List<ViatorNoneAvailableDatesBean> nonAvailDates=null;
        String hql=  " select  DISTINCT(nonAvailDates)" +
                     " from Beans.ViatorDBBeans.ViatorNoneAvailableDatesBean nonAvailDates ";
        int i=0;
        for(ViatorProductDetailsBean productDetails:productsDetails){
            if(i==0)
              hql= hql + " where nonAvailDates.productCode= :code" + i;
            else
              hql= hql + " or nonAvailDates.productCode= :code" + i;
            i++;
        }
        hql= hql + " order by nonAvailDates.year asc,nonAvailDates.month asc,nonAvailDates.day asc";
        try{
            session.beginTransaction();
            Query query=session.createQuery(hql);
            i=0;
            for(ViatorProductDetailsBean productDetails:productsDetails){
                query.setParameter("code"+i,productDetails.getCode());
                i++;
            }
            nonAvailDates=query.getResultList();
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

        return nonAvailDates;
    }


}
