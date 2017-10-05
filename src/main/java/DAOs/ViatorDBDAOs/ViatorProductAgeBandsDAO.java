package DAOs.ViatorDBDAOs;

import Beans.ViatorDBBeans.ViatorProductAgeBandsBean;
import DBConnection.HibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by George on 20/06/17.
 */
public class ViatorProductAgeBandsDAO {

    public static boolean addproductagebandsBean(ViatorProductAgeBandsBean viatorproductagebandsBean){

        Session session = HibernateUtil.getSession();
        Transaction tx;
        boolean err=false;
        try{

            tx=session.beginTransaction();
            session.save(viatorproductagebandsBean);
            tx.commit();
            session.close();
        }catch (HibernateException e) {
            err=true;
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            err=true;
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            err=true;
            e.printStackTrace();
        }
        return err;
    }

    public static boolean deleteProductAgeBands(String productCode){

        Session session = HibernateUtil.getSession();
        String hql = String.format("DELETE FROM ViatorProductAgeBandsBean WHERE productCode='"+productCode+"'");
        boolean err=false;
        try{
            session.beginTransaction();
            session.createQuery(hql).executeUpdate();
            session.getTransaction().commit();
            session.close();
        }catch (HibernateException e) {
            err=true;
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            err=true;
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            err=true;
            e.printStackTrace();
        }
        return err;
    }

    public static List<ViatorProductAgeBandsBean> getAgeBandsByProductCode(String productCode){

        Session session = HibernateUtil.getSession();
        List<ViatorProductAgeBandsBean> ageBands=null;
        String hql ="Select ageBands FROM ViatorProductAgeBandsBean ageBands " +
                                    "WHERE ageBands.productCode like :productCode " +
                                    "order by ageBands.sortOrder";
        try{
            session.beginTransaction();
            ageBands=session.createQuery(hql).setParameter("productCode",   productCode ).getResultList();
            session.getTransaction().commit();
            session.close();
        }catch (HibernateException e) {
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            e.printStackTrace();
        }
        return ageBands;
    }
}
