package DAOs.ATBDBDAOs.KalitaonProductDAOs;

import Beans.ATBDBBeans.KalitaonProduct.DProductPhotoBean;
import DBConnection.ATBHibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import org.hibernate.HibernateException;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by George on 18/08/2017.
 */
public class DProductPhotoDAO {

    public static boolean addPhoto(List<DProductPhotoBean> photos){

        StatelessSession session = ATBHibernateUtil.getSession();
        Transaction tx;
        boolean err=false;
        try{

            tx=session.beginTransaction();
            for(DProductPhotoBean photo:photos)
                session.insert(photo);
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

    public static boolean deletePhoto(String code){

        StatelessSession session = ATBHibernateUtil.getSession();
        String hql = String.format("DELETE FROM DProductPhotoBean WHERE productId='"+code+"'");
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

    public static List<DProductPhotoBean> getdProductPhotosByProductId(String productId){

        StatelessSession session = ATBHibernateUtil.getSession();
        List<DProductPhotoBean> dProductPhotos=null;
        String hql ="Select dProductPhotos FROM DProductPhotoBean dProductPhotos " +
                "WHERE dProductPhotos.productId like :productId ";
        try{
            session.beginTransaction();
            dProductPhotos=session.createQuery(hql).setParameter("productId",   productId ).getResultList();
            session.getTransaction().commit();
            session.close();
        }catch (HibernateException e) {
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }catch (CJCommunicationsException e){

            e.printStackTrace();
        }
        return dProductPhotos;
    }
}
