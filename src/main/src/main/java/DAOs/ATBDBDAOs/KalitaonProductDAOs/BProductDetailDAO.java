package DAOs.ATBDBDAOs.KalitaonProductDAOs;

import Beans.ATBDBBeans.KalitaonProduct.BProductDetailBean;
import DBConnection.ATBHibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import org.hibernate.HibernateException;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import static Controller.Application.errLogger;

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
        }catch (HibernateException e) {
            err=true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ExceptionInInitializerError e) {
            err=true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (CJCommunicationsException e){
            err=true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }finally {
            session.close();
        }
        return err;
    }

    public static boolean saveOrUpdateProductDetail(List<BProductDetailBean> products){
        StatelessSession session = ATBHibernateUtil.getSession();
        Transaction tx;
        boolean err=false;
        try{
            tx=session.beginTransaction();
            for(BProductDetailBean product:products) {
                String hql ="Select product.id FROM BProductDetailBean product " +
                        "WHERE product.productId like :productId ";
                int id;
                try {
                    id = (int) session.createQuery(hql).setParameter("productId", product.getProductId())
                            .getSingleResult();
                } catch (NoResultException e) {
                    id = 0;
                }
                if (id != 0) {
                    product.setId(id);
                    session.update(product);
                } else {
                    product.setId(0);
                    session.insert(product);
                }
            }
            tx.commit();
        }catch (HibernateException e) {
            err=true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ExceptionInInitializerError e) {
            err=true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (CJCommunicationsException e){
            err=true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch(NoResultException e){
            err=true;
        }finally {
            session.close();
        }
        return err;
    }

    public static boolean deleteProduct(String productId){

        StatelessSession session = ATBHibernateUtil.getSession();
        String hql = String.format("DELETE FROM BProductDetailBean WHERE productId='"+productId+"'");
        boolean err=false;
        try{
            session.beginTransaction();
            session.createQuery(hql).executeUpdate();
            session.getTransaction().commit();
        }catch (HibernateException e) {
            err=true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ExceptionInInitializerError e) {
            err=true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (CJCommunicationsException e){
            err=true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }finally {
            session.close();
        }
        return err;
    }

    public static List<BProductDetailBean> getBProductDetailsByProductId(String productId){

        StatelessSession session = ATBHibernateUtil.getSession();
        List<BProductDetailBean> bProductDetails=null;
        String hql ="Select bProductDetails FROM BProductDetailBean bProductDetails " +
                "WHERE bProductDetails.productId like :productId ";
        try{
            session.beginTransaction();
            bProductDetails=session.createQuery(hql).setParameter("productId",   productId ).getResultList();
            session.getTransaction().commit();
        }catch (HibernateException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ExceptionInInitializerError e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (CJCommunicationsException e){
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }finally {
            session.close();
        }
        return bProductDetails;
    }
}
