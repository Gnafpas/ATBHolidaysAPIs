package DAOs.DBDAOs;

import DBBeans.ViatorProductUserPhotosBean;
import DBConnection.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by George on 20/06/17.
 */
public class ViatorProductUserPhotosDAO {
//todo add table to DB for travel agent photos
    private HibernateUtil helper;
    private Session session;

    public boolean addproductuserphotos(ViatorProductUserPhotosBean viatorproductuserphotosBean ){

        Transaction tx;
        boolean err=false;
        try{
            session = helper.getSession();
            tx=session.beginTransaction();
            session.save(viatorproductuserphotosBean);
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

    public boolean deleteProductUserPhotos(String productCode){

        String hql = String.format("DELETE FROM ViatorProductUserPhotosBean WHERE productCode='"+productCode+"'");
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
