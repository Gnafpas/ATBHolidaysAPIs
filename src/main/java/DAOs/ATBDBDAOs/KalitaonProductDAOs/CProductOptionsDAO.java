package DAOs.ATBDBDAOs.KalitaonProductDAOs;

import Beans.ATBDBBeans.KalitaonProduct.CProductOptionsBean;
import DBConnection.ATBHibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import org.hibernate.HibernateException;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by George on 20/08/2017.
 */
public class CProductOptionsDAO {

    public static boolean addProductOption(List<CProductOptionsBean> productOptions){

        StatelessSession session = ATBHibernateUtil.getSession();
        Transaction tx;
        boolean err=false;
        try{
            tx=session.beginTransaction();
            for(CProductOptionsBean productOption:productOptions)
                session.insert(productOption);
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

    public static boolean deleteProductOption(String code){

        StatelessSession session = ATBHibernateUtil.getSession();
        String hql = String.format("DELETE FROM CProductOptionsBean WHERE productId='"+code+"'");
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

            e.printStackTrace();
        }finally {
            session.close();
        }
        return err;
    }

    public static List<CProductOptionsBean> getcProductOptionsByProductId(String productId){

        StatelessSession session = ATBHibernateUtil.getSession();
        List<CProductOptionsBean> cProductOptions=null;
        String hql ="Select cProductOptions FROM CProductOptionsBean cProductOptions " +
                "WHERE cProductOptions.productId like :productId ";
        try{
            session.beginTransaction();
            cProductOptions=session.createQuery(hql).setParameter("productId",   productId ).getResultList();
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
        return cProductOptions;
    }
}
