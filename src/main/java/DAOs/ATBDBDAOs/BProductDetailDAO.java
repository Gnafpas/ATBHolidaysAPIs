package DAOs.ATBDBDAOs;

import ATBDBBeans.BProductDetailBean;
import DBConnection.ATBHibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by George on 09/08/2017.
 */
public class BProductDetailDAO {

    public static boolean addproduct(List<BProductDetailBean> products){

        StatelessSession session = ATBHibernateUtil.getSession();
        Transaction tx;
        boolean err=false;
        try{
            tx=session.beginTransaction();
            for(BProductDetailBean product:products)
                session.insert(product);
            tx.commit();
            session.close();
        }catch (HibernateException e) {
            err=true;
            e.printStackTrace();
            session.close();
        }catch (ExceptionInInitializerError e) {
            err=true;
            e.printStackTrace();
            session.close();
        }
        return err;
    }

    public static boolean deleteProduct(String code){

        StatelessSession session = ATBHibernateUtil.getSession();
        String hql = String.format("DELETE FROM BProductDetailBean WHERE productId='"+code+"'");
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
            session.close();
        }
        return err;
    }
}
