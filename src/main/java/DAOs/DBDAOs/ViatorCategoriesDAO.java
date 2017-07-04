package DAOs.DBDAOs;

import DBBeans.ViatorCategoriesBean;
import DBConnection.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by George on 19/06/17.
 */
public class ViatorCategoriesDAO {

    private HibernateUtil helper;
    private Session session;

    public boolean addcategory(ViatorCategoriesBean viatorcategoriesBean){

        Transaction tx;
        boolean err=false;
        try{
            session = helper.getSession();
            tx=session.beginTransaction();
            session.save(viatorcategoriesBean);
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

    public boolean deleteCategory(int catId){

        String hql = String.format("delete from ViatorCategoriesBean WHERE id='"+catId+"'");
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
