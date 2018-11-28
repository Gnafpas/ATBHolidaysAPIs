package DAOs.ViatorDBDAOs;

import Beans.ViatorDBBeans.ViatorCategoriesBean;
import Beans.ViatorDBBeans.ViatorProductXCategoryBean;
import DBConnection.HibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import static Controller.Application.errLogger;

/**
 * Created by George on 10/06/17.
 */
public class ViatorProductXCategoryDAO {

    public static boolean addprodactXcategory(ViatorProductXCategoryBean viatorproductXcategoryBean,StatelessSession session){

        boolean err=false;
        try{
            session.insert(viatorproductXcategoryBean);
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
        }
        return err;
    }

    public static boolean deleteProductXCategory(String productCode){

        StatelessSession session = HibernateUtil.getSession();
        String hql = String.format("DELETE FROM ViatorProductXCategoryBean WHERE productCode='"+productCode+"'");
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

    public static List<ViatorCategoriesBean> getProductCategoriesByProductCode(String productCode){

        StatelessSession session = HibernateUtil.getSession();
        List<ViatorCategoriesBean> category=null;
        String hql ="Select category FROM ViatorProductXCategoryBean productXCategory ,ViatorCategoriesBean  category " +
                                    "WHERE productXCategory.productCode like :productCode " +
                                    "AND   category.id=productXCategory.categoryId " +
                                    "order by category.sortOrder ";
        try{
            session.beginTransaction();
            category=session.createQuery(hql).setParameter("productCode",   productCode ).getResultList();
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
        return category;
    }

}
