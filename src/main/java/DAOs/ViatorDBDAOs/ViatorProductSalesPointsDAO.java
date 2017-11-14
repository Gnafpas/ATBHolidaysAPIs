package DAOs.ViatorDBDAOs;

import Beans.ViatorDBBeans.ViatorProductSalesPointsBean;
import DBConnection.HibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by George on 20/06/17.
 */
public class ViatorProductSalesPointsDAO {

    public static boolean addproductsalespointsBean(ViatorProductSalesPointsBean viatorproductsalespointsBean){

        Session session = HibernateUtil.getSession();
        Transaction tx;
        boolean err=false;
        try{
            tx=session.beginTransaction();
            session.save(viatorproductsalespointsBean);
            tx.commit();
        }catch (HibernateException e) {
            err=true;
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            err=true;
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            err=true;
            e.printStackTrace();
        }finally {
            session.close();
        }
        return err;
    }

    public static boolean deleteProductSalesPoints(String productCode){

        Session session = HibernateUtil.getSession();
        String hql = String.format("DELETE FROM ViatorProductSalesPointsBean WHERE productCode='"+productCode+"'");
        boolean err=false;
        try{
            session.beginTransaction();
            session.createQuery(hql).executeUpdate();
            session.getTransaction().commit();
        }catch (HibernateException e) {
            err=true;
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            err=true;
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            err=true;
            e.printStackTrace();
        }finally {
            session.close();
        }
        return err;
    }

    public static List<ViatorProductSalesPointsBean> getSalesPointsByProductCode(String productCode){

        Session session = HibernateUtil.getSession();
        List<ViatorProductSalesPointsBean> salesPoints=null;
        String hql ="Select salesPoints FROM ViatorProductSalesPointsBean salesPoints " +
                                       "WHERE salesPoints.productCode like :productCode ";
        try{
            session.beginTransaction();
            salesPoints=session.createQuery(hql).setParameter("productCode",   productCode ).getResultList();
            session.getTransaction().commit();
        }catch (HibernateException e) {
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return salesPoints;
    }
}
