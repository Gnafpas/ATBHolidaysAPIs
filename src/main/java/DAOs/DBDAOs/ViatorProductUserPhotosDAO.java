package DAOs.DBDAOs;

import DBBeans.ViatorProductUserPhotosBean;
import DBConnection.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by George on 20/06/17.
 */
public class ViatorProductUserPhotosDAO {

    public static boolean addproductuserphotos(ViatorProductUserPhotosBean viatorproductuserphotosBean ){

        Session session = HibernateUtil.getSession();
        Transaction tx;
        boolean err=false;
        try{
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

    public static boolean deleteProductUserPhotos(String productCode){

        Session session = HibernateUtil.getSession();
        String hql = String.format("DELETE FROM ViatorProductUserPhotosBean WHERE productCode='"+productCode+"'");
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

    public static List<ViatorProductUserPhotosBean> getUserPhotosByProductCode(String productCode){

        Session session = HibernateUtil.getSession();
        List<ViatorProductUserPhotosBean> userPhotos=null;
        String hql ="Select userPhotos FROM ViatorProductUserPhotosBean userPhotos " +
                                      "WHERE userPhotos.productCode like :productCode " +
                                      "order by userPhotos.sortOrder ";
        try{
            session.beginTransaction();
            userPhotos=session.createQuery(hql).setParameter("productCode",   productCode ).getResultList();
            session.getTransaction().commit();
            session.close();
        }catch (HibernateException e) {
            e.printStackTrace();
            session.close();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }
        return userPhotos;
    }
}
