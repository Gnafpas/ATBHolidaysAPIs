package DAOs.DBDAOs;

import DBBeans.ViatorProductExclusionsBean;
import DBBeans.ViatorProductPhotosBean;
import DBConnection.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by George on 23/06/17.
 */
public class ViatorProductPhotosDAO {

    public static boolean addproductphotos(ViatorProductPhotosBean viatorproductphotosBean ){

        Session session = HibernateUtil.getSession();
        Transaction tx;
        boolean err=false;
        try{

            tx=session.beginTransaction();
            session.save(viatorproductphotosBean);
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

    public static boolean deleteProductPhotos(String productCode){

        Session session = HibernateUtil.getSession();
        String hql = String.format("DELETE FROM ViatorProductPhotosBean WHERE productCode='"+productCode+"'");
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

    public static List<ViatorProductPhotosBean> getPhotosByProductCode(String productCode){

        Session session = HibernateUtil.getSession();
        List<ViatorProductPhotosBean> photos=null;
        String hql ="Select photos FROM ViatorProductPhotosBean photos " +
                                  "WHERE photos.productCode like :productCode ";
        try{
            session.beginTransaction();
            photos=session.createQuery(hql).setParameter("productCode",   productCode ).getResultList();
            session.getTransaction().commit();
            session.close();
        }catch (HibernateException e) {
            e.printStackTrace();
            session.close();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }
        return photos;
    }
}
