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

    private HibernateUtil helper;
    private Session session;

    public boolean addsubcategory(ViatorSubcategoriesBean viatorsubcategoriesBean){

        Transaction tx;
        boolean err=false;
        try{
            session = helper.getSession();
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

    public boolean deleteSubcategory(int subcaatId,int catId){

        String hql = String.format("delete from ViatorSubcategoriesBean WHERE id='"+subcaatId+"' AND categoryId='"+catId+"'");
        boolean err=false;
        try{
            session = helper.getSession();
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

    public List<ViatorSubcategoriesBean> getAllSubcategories() {
        List<ViatorSubcategoriesBean> subCategories = null;
        String hql = "select categories from ViatorCategoriesBean categories";
        try {
            session = helper.getSession();
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


    public List<ViatorSubcategoriesBean> getSubcategoriesByCategoriId(int categoriId){

        List<ViatorSubcategoriesBean> subcategories=null;
        String hql ="Select subcategories FROM ViatorSubcategoriesBean subcategories WHERE subcategories.categoryId= :categoriId" ;
        boolean err=false;
        try{
            session = helper.getSession();
            session.beginTransaction();
            subcategories=session.createQuery(hql).setParameter("categoriId",   categoriId ).getResultList();
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
        return subcategories;
    }
}
