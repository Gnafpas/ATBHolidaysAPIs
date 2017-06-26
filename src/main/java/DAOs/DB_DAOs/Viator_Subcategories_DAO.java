package DAOs.DB_DAOs;

import DB_Beans.ViatorCategoriesBean;
import DB_Beans.ViatorProductXSubcategoryBean;
import DB_Beans.ViatorSubcategoriesBean;
import DB_Connection.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;

/**
 * Created by George on 19/06/17.
 */
public class Viator_Subcategories_DAO {

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

    public boolean deleteSubcategory(int subcaatId){

        String hql = String.format("delete from ViatorSubcategoriesBean WHERE id='"+subcaatId+"'");
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
}
