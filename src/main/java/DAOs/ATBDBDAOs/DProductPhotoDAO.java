package DAOs.ATBDBDAOs;

import ATBDBBeans.DProductPhotoBean;
import DBConnection.ATBHibernateUtil;
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
            session.close();
        }catch (ExceptionInInitializerError e) {
            err=true;
            e.printStackTrace();
            session.close();
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
            session.close();
        }catch (ExceptionInInitializerError e) {
            err=true;
            e.printStackTrace();
            session.close();
        }
        return err;
    }
}
