package DAOs.DBDAOs;

import DBBeans.ViatorCategoriesBean;
import DBBeans.ViatorSubcategoriesBean;
import DBConnection.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by George on 19/06/17.
 */
public class ViatorSubcategoriesDAO {

    public static boolean addsubcategory(ViatorSubcategoriesBean viatorsubcategoriesBean){

        Session session = HibernateUtil.getSession();
        Transaction tx;
        boolean err=false;
        try{
            tx=session.beginTransaction();
            session.save(viatorsubcategoriesBean);
            tx.commit();
            session.close();
        }catch (HibernateException e) {
            err=true;
            e.printStackTrace();
            session.close();
        }catch (ExceptionInInitializerError e) {
            err=true;
            e.printStackTrace();
        }
        return err;
    }

    public static boolean deleteSubcategory(int id){

        Session session = HibernateUtil.getSession();
        String hql = String.format("delete from ViatorSubcategoriesBean WHERE id='"+ id +"'");
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
        }
        return err;

    }

    public static List<ViatorSubcategoriesBean> getAllSubcategories() {

        Session session = HibernateUtil.getSession();
        List<ViatorSubcategoriesBean> subCategories = null;
        String hql = "select categories from ViatorCategoriesBean categories";
        try {
            session.beginTransaction();
            subCategories = session.createQuery(hql).list();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.close();
        } catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }
        return subCategories;
    }


    public static List<ViatorSubcategoriesBean> getSubcategoriesByCategoriId(int categoriId){

        Session session = HibernateUtil.getSession();
        List<ViatorSubcategoriesBean> subcategories=null;
        String hql ="Select subcategories FROM ViatorSubcategoriesBean subcategories WHERE subcategories.categoryId= :categoriId" ;
        try{
            session.beginTransaction();
            subcategories=session.createQuery(hql).setParameter("categoriId",   categoriId ).getResultList();
            session.getTransaction().commit();
            session.close();
        }catch (HibernateException e) {
            e.printStackTrace();
            session.close();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }
        return subcategories;
    }
}
