package DAOs.ATBDBDAOs.KalitaonProductDAOs;

import Beans.ATBDBBeans.KalitaonProduct.CProductOptionsBean;
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

    public static boolean saveOrUpdateProductOption(List<CProductOptionsBean> productOptions){
        StatelessSession session = ATBHibernateUtil.getSession();
        Transaction tx;
        boolean err=false;
        try{
            tx=session.beginTransaction();
            for(CProductOptionsBean productOption:productOptions) {
                String hql ="Select productOption.id FROM CProductOptionsBean productOption " +
                        "WHERE productOption.productId like :productId ";
                int id;
                try {
                    id = (int) session.createQuery(hql).setParameter("productId", productOption.getProductId())
                            .getSingleResult();
                } catch (NoResultException e) {
                    id = 0;
                }
                if (id != 0) {
                    productOption.setId(id);
                    session.update(productOption);
                } else {
                    productOption.setId(0);
                    session.insert(productOption);
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
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ExceptionInInitializerError e) {
            err=true;
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
        return cProductOptions;
    }
}
