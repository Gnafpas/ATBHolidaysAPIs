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
    private HibernateUtil helper;
    private Session session;

    public boolean addproductphotos(ViatorProductPhotosBean viatorproductphotosBean ){

        Transaction tx;
        boolean err=false;
        try{
            session = helper.getSession();
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

    public boolean deleteProductPhotos(String productCode){

        String hql = String.format("DELETE FROM ViatorProductPhotosBean WHERE productCode='"+productCode+"'");
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

    public List<ViatorProductPhotosBean> getPhotosByProductCode(String productCode){

        List<ViatorProductPhotosBean> photos=null;
        String hql ="Select photos FROM ViatorProductPhotosBean photos " +
                                  "WHERE photos.productCode like :productCode ";
        try{
            session = helper.getSession();
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
