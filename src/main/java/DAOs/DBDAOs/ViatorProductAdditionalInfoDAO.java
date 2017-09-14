package DAOs.DBDAOs;

import DBBeans.ViatorProductAdditionalInfoBean;
import DBConnection.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by George on 23/06/17.
 */
public class ViatorProductAdditionalInfoDAO {

    public static boolean addproductadditionalinfo(ViatorProductAdditionalInfoBean viatorproductadditionalinfoBean){

        Session session = HibernateUtil.getSession();
        Transaction tx;
        boolean err=false;
        try{

            tx=session.beginTransaction();
            session.save(viatorproductadditionalinfoBean);
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

    public static boolean deleteProductAdditionalInfo(String productCode){

        Session session = HibernateUtil.getSession();
        String hql = String.format("DELETE FROM ViatorProductAdditionalInfoBean WHERE productCode='"+productCode+"'");
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

    public static List<ViatorProductAdditionalInfoBean> getAdditionalInfoByProductCode(String productCode){

        Session session = HibernateUtil.getSession();List<ViatorProductAdditionalInfoBean> additionalInfo=null;
        String hql ="Select additionalInfo FROM ViatorProductAdditionalInfoBean additionalInfo " +
                                          "WHERE additionalInfo.productCode like :productCode ";
        try{
            session.beginTransaction();
            additionalInfo=session.createQuery(hql).setParameter("productCode",   productCode ).getResultList();
            session.getTransaction().commit();
            session.close();
        }catch (HibernateException e) {
            e.printStackTrace();
            session.close();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }
        return additionalInfo;
    }
}
