package DAOs.ViatorDBDAOs;

import Beans.ViatorDBBeans.ViatorCategoriesBean;
import DBConnection.HibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by George on 19/06/17.
 */
public class ViatorCategoriesDAO {


    public static boolean addcategory(ViatorCategoriesBean viatorcategoriesBean){

        Session session = HibernateUtil.getSession();
        Transaction tx;
        boolean err=false;
        try{
            tx=session.beginTransaction();
            session.save(viatorcategoriesBean);
            tx.commit();
            session.close();
        }catch (HibernateException e) {
            err=true;
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            err=true;
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            err=true;
            e.printStackTrace();
        }
        return err;
    }

    public static boolean deleteCategory(int catId){

        Session session = HibernateUtil.getSession();
        String hql = String.format("delete from ViatorCategoriesBean WHERE id='"+catId+"'");
        boolean err=false;
        try{
            session.beginTransaction();
            session.createQuery(hql).executeUpdate();
            session.getTransaction().commit();
            session.close();
        }catch (HibernateException e) {
            err=true;
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            err=true;
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            err=true;
            e.printStackTrace();
        }
        return err;
    }

    public static List<ViatorCategoriesBean> getAllCategories(){
        Session session = HibernateUtil.getSession();
        List <ViatorCategoriesBean> categories=null;
        String hql = "select categories from ViatorCategoriesBean categories";
        try{
            session.beginTransaction();
            categories=session.createQuery(hql).list();
            session.close();
        }catch (HibernateException e) {
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            e.printStackTrace();
        }
        return categories;
    }

}
