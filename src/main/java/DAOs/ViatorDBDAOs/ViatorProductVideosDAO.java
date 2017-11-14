package DAOs.ViatorDBDAOs;

import Beans.ViatorDBBeans.ViatorProductVideosBean;
import DBConnection.HibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by George on 23/06/17.
 */
public class ViatorProductVideosDAO {

    public static boolean addproductvideos(ViatorProductVideosBean viatorproductvideosBean){

        Session session = HibernateUtil.getSession();
        Transaction tx;
        boolean err=false;
        try{
            tx=session.beginTransaction();
            session.save(viatorproductvideosBean);
            tx.commit();
        }catch (HibernateException e) {
            err=true;
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            err=true;
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            err=true;
            e.printStackTrace();
        }finally {
            session.close();
        }
        return err;
    }

    public static boolean deleteProductVideos(String productCode){

        Session session = HibernateUtil.getSession();
        String hql = String.format("DELETE FROM ViatorProductVideosBean WHERE productCode='"+productCode+"'");
        boolean err=false;
        try{
            session.beginTransaction();
            session.createQuery(hql).executeUpdate();
            session.getTransaction().commit();
        }catch (HibernateException e) {
            err=true;
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            err=true;
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            err=true;
            e.printStackTrace();
        }finally {
            session.close();
        }
        return err;
    }

    public static List<ViatorProductVideosBean> getVideosByProductCode(String productCode){

        Session session = HibernateUtil.getSession();
        List<ViatorProductVideosBean> videos=null;
        String hql ="Select videos FROM ViatorProductVideosBean videos " +
                                  "WHERE videos.productCode like :productCode " +
                                  "order by videos.sortOrder ";
        try{
            session.beginTransaction();
            videos=session.createQuery(hql).setParameter("productCode",   productCode ).getResultList();
            session.getTransaction().commit();
        }catch (HibernateException e) {
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return videos;
    }
}
