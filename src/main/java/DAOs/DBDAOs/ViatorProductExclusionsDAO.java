package DAOs.DBDAOs;

import DBBeans.ViatorProductExclusionsBean;
import DBConnection.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by George on 23/06/17.
 */
public class ViatorProductExclusionsDAO {

    public static boolean addproductexclusions(ViatorProductExclusionsBean viatorproductexclusionsBean){

        Session session = HibernateUtil.getSession();
        Transaction tx;
        boolean err=false;
        try{
            tx=session.beginTransaction();
            session.save(viatorproductexclusionsBean);
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

    public static boolean deleteProductExlusions(String productCode){

        Session session = HibernateUtil.getSession();
        String hql = String.format("DELETE FROM ViatorProductExclusionsBean WHERE productCode='"+productCode+"'");
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

    public static List<ViatorProductExclusionsBean> getExclusionsByProductCode(String productCode){

        Session session = HibernateUtil.getSession();
        List<ViatorProductExclusionsBean> exclusions=null;
        String hql ="Select exclusions FROM ViatorProductExclusionsBean exclusions " +
                                      "WHERE exclusions.productCode like :productCode ";
        try{
            session.beginTransaction();
            exclusions=session.createQuery(hql).setParameter("productCode",   productCode ).getResultList();
            session.getTransaction().commit();
            session.close();
        }catch (HibernateException e) {
            e.printStackTrace();
            session.close();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }
        return exclusions;
    }
}
