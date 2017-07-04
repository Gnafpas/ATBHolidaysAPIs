package DAOs.DBDAOs;

import DBBeans.ViatorProductXCategoryBean;
import DBConnection.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolationException;

/**
 * Created by George on 10/06/17.
 */
public class ViatorProductXCategoryDAO {

    private HibernateUtil helper;
    private Session session;

    public boolean addprodactXcategory(ViatorProductXCategoryBean viatorproductXcategoryBean){

        Transaction tx;
        boolean err=false;
        try{
            session = helper.getSession();
            tx=session.beginTransaction();
            session.save(viatorproductXcategoryBean);
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

    public boolean deleteProductXCategory(String productCode){

        String hql = String.format("DELETE FROM ViatorProductXCategoryBean WHERE productCode='"+productCode+"'");
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
