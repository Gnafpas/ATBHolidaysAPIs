package DAOs.ATBDBDAOs.KalitaonProductDAOs;

import Beans.ATBDBBeans.KalitaonProduct.ProductCategoriesBean;
import DBConnection.ATBHibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import org.hibernate.HibernateException;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import static Controller.Application.errLogger;

/**
 * Created by George on 18/09/2017.
 */
public class ProductCategoriesDAO {

    public static boolean addProductCategoriesBean(ProductCategoriesBean productCategoriesBean) {
        StatelessSession session = ATBHibernateUtil.getSession();
        Transaction tx;
        boolean err = false;
        try {
            tx = session.beginTransaction();
            session.insert(productCategoriesBean);
            tx.commit();
        } catch (HibernateException e) {
            err = true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        } catch (ExceptionInInitializerError e) {
            err = true;
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

    public static List<ProductCategoriesBean> getAllCategories(){

        StatelessSession session = ATBHibernateUtil.getSession();
        List <ProductCategoriesBean> categories=null;
        String hql = "select categories from ProductCategoriesBean categories ";
        try{
            session.beginTransaction();
            categories=session.createQuery(hql).list();
        }catch (HibernateException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ExceptionInInitializerError e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (CJCommunicationsException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }finally {
                session.close();
            }
        return categories;
    }
}
