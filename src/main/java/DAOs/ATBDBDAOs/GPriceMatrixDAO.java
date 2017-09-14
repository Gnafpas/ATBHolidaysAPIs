package DAOs.ATBDBDAOs;

import ATBDBBeans.GPriceMatrixBean;
import DBConnection.ATBHibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by George on 20/08/2017.
 */
public class GPriceMatrixDAO {
    public static boolean addPriceMatrix(List<GPriceMatrixBean> priceMatrixes){

        StatelessSession session = ATBHibernateUtil.getSession();
        Transaction tx;
        boolean err=false;
        try{
            tx=session.beginTransaction();
            for(GPriceMatrixBean priceMatrix:priceMatrixes)
                session.insert(priceMatrix);
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

    public static boolean deletePriceMatrix(String code){

        StatelessSession session = ATBHibernateUtil.getSession();
        String hql = String.format("DELETE FROM GPriceMatrixBean WHERE productId='"+code+"'");
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
