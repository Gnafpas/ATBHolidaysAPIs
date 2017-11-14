package DAOs.ATBDBDAOs.KalitaonProductDAOs;

import Beans.ATBDBBeans.KalitaonProduct.GPriceMatrixBean;
import DBConnection.ATBHibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
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

    public static boolean deletePriceMatrix(String code){

        StatelessSession session = ATBHibernateUtil.getSession();
        String hql = String.format("DELETE FROM GPriceMatrixBean WHERE productId='"+code+"'");
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

    public static List<GPriceMatrixBean> getgPriceMatrixesByProductId(String productId,String planId){

        StatelessSession session = ATBHibernateUtil.getSession();
        List<GPriceMatrixBean> gPriceMatrixes=null;
        String hql ="Select gPriceMatrixes FROM GPriceMatrixBean gPriceMatrixes " +
                "WHERE gPriceMatrixes.productId like :productId " +
                "AND   gPriceMatrixes.planId like :planId";
        try{
            session.beginTransaction();
            gPriceMatrixes=session.createQuery(hql).setParameter("productId",   productId )
                                                   .setParameter("planId",   "%"+planId+"%" )
                                                   .getResultList();
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
        return gPriceMatrixes;
    }
}
