package DAOs.DBDAOs;

import DBBeans.ViatorProductSalesPointsBean;
import DBConnection.HibernateUtil;
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

    public static boolean deleteProductSalesPoints(String productCode){

        Session session = HibernateUtil.getSession();
        String hql = String.format("DELETE FROM ViatorProductSalesPointsBean WHERE productCode='"+productCode+"'");
        boolean err=false;
        try{
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

    public static List<ViatorProductSalesPointsBean> getSalesPointsByProductCode(String productCode){

        Session session = HibernateUtil.getSession();
        List<ViatorProductSalesPointsBean> salesPoints=null;
        String hql ="Select salesPoints FROM ViatorProductSalesPointsBean salesPoints " +
                                       "WHERE salesPoints.productCode like :productCode ";
        try{
            session.beginTransaction();
            salesPoints=session.createQuery(hql).setParameter("productCode",   productCode ).getResultList();
            session.getTransaction().commit();
            session.close();
        }catch (HibernateException e) {
            e.printStackTrace();
            session.close();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }
        return salesPoints;
    }
}
