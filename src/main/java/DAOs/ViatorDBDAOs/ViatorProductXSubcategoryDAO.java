package DAOs.ViatorDBDAOs;

import Beans.ViatorDBBeans.ViatorProductXSubcategoryBean;
import Beans.ViatorDBBeans.ViatorSubcategoriesBean;
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
 * Created by George on 20/06/17.
 */
public class ViatorProductXSubcategoryDAO {

    public static boolean addprodactXsubcategory(ViatorProductXSubcategoryBean viatorproductxsubcategoryBean,StatelessSession session ){

        boolean err=false;
        try{
            session.insert(viatorproductxsubcategoryBean);
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

    public static boolean deleteProductXSubctegory(String productCode){

        StatelessSession session = HibernateUtil.getSession();
        String hql = String.format("DELETE FROM ViatorProductXSubcategoryBean WHERE productCode='"+productCode+"'");
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

    public static List<ViatorSubcategoriesBean> getProductSubcategoriesByProductCode(String productCode,int categoryId){

        StatelessSession session = HibernateUtil.getSession();
        List<ViatorSubcategoriesBean> subcategory=null;
        String hql ="Select subcategory FROM ViatorProductXSubcategoryBean productXSubcategory ,ViatorCategoriesBean category ,ViatorSubcategoriesBean subcategory " +
                                       "WHERE productXSubcategory.productCode like :productCode " +
                                       "AND   subcategory.id = productXSubcategory.subcategoryId " +
                                       "AND   category.id = subcategory.categoryId " +
                                       "AND   category.id = :categoryId " +
                                       "order by subcategory.sortOrder ";
        try{
            session.beginTransaction();
            subcategory=session.createQuery(hql).setParameter("productCode",   productCode )
                                                .setParameter("categoryId",   categoryId )
                                                .getResultList();
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
        return subcategory;
    }
}
