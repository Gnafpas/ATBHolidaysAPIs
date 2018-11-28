package DAOs.ViatorDBDAOs;

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
 * Created by George on 19/06/17.
 */
public class ViatorSubcategoriesDAO {

    public static boolean addsubcategory(ViatorSubcategoriesBean viatorsubcategoriesBean){

        StatelessSession session = HibernateUtil.getSession();
        Transaction tx;
        boolean err=false;
        try{
            tx=session.beginTransaction();
            session.insert(viatorsubcategoriesBean);
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

    public static boolean deleteSubcategory(int id){

        StatelessSession session = HibernateUtil.getSession();
        String hql = String.format("delete from ViatorSubcategoriesBean WHERE id='"+ id +"'");
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

    public static List<ViatorSubcategoriesBean> getAllSubcategories() {

        StatelessSession session = HibernateUtil.getSession();
        List<ViatorSubcategoriesBean> subCategories = null;
        String hql = "select categories from ViatorCategoriesBean categories";
        try {
            session.beginTransaction();
            subCategories = session.createQuery(hql).list();
        } catch (HibernateException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        } catch (ExceptionInInitializerError e) {
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
        return subCategories;
    }


    public static List<ViatorSubcategoriesBean> getSubcategoriesByCategoriId(int categoriId){

        StatelessSession session = HibernateUtil.getSession();
        List<ViatorSubcategoriesBean> subcategories=null;
        String hql ="Select subcategories FROM ViatorSubcategoriesBean subcategories WHERE subcategories.categoryId= :categoriId" ;
        try{
            session.beginTransaction();
            subcategories=session.createQuery(hql).setParameter("categoriId",   categoriId ).getResultList();
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
        return subcategories;
    }
}
