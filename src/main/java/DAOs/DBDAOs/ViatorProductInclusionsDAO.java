package DAOs.DBDAOs;

import DBBeans.ViatorProductInclusionsBean;
import DBConnection.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by George on 23/06/17.
 */
public class ViatorProductInclusionsDAO {
    private HibernateUtil helper;
    private Session session;

    public boolean addproductinclusions(ViatorProductInclusionsBean productinclusionsBean){

        Transaction tx;
        boolean err=false;
        try{
            session = helper.getSession();
            tx=session.beginTransaction();
            session.save(productinclusionsBean);
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

    public boolean deleteProductInclusions(String productCode){

        String hql = String.format("DELETE FROM ViatorProductInclusionsBean WHERE productCode='"+productCode+"'");
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

    public List<ViatorProductInclusionsBean> getInclusionsByProductCode(String productCode){

        List<ViatorProductInclusionsBean> inclusions=null;
        String hql ="Select inclusions FROM ViatorProductInclusionsBean inclusions " +
                                      "WHERE inclusions.productCode like :productCode ";
        try{
            session = helper.getSession();
            session.beginTransaction();
            inclusions=session.createQuery(hql).setParameter("productCode",   productCode ).getResultList();
            session.getTransaction().commit();
            session.close();
        }catch (HibernateException e) {
            e.printStackTrace();
            session.close();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }
        return inclusions;
    }
}
