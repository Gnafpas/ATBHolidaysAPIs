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
    private HibernateUtil helper;
    private Session session;

    public boolean addproductadditionalinfo(ViatorProductAdditionalInfoBean viatorproductadditionalinfoBean){

        Transaction tx;
        boolean err=false;
        try{
            session = helper.getSession();
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

    public boolean deleteProductAdditionalInfo(String productCode){

        String hql = String.format("DELETE FROM ViatorProductAdditionalInfoBean WHERE productCode='"+productCode+"'");
        boolean err=false;
        try{
            session = helper.getSession();
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

    public List<ViatorProductAdditionalInfoBean> getAdditionalInfoByProductCode(String productCode){

        List<ViatorProductAdditionalInfoBean> additionalInfo=null;
        String hql ="Select additionalInfo FROM ViatorProductAdditionalInfoBean additionalInfo " +
                                          "WHERE additionalInfo.productCode like :productCode ";
        try{
            session = helper.getSession();
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
