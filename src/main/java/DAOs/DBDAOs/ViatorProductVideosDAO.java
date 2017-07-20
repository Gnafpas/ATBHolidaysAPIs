package DAOs.DBDAOs;

import DBBeans.ViatorProductVideosBean;
import DBConnection.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by George on 23/06/17.
 */
public class ViatorProductVideosDAO {
    private HibernateUtil helper;
    private Session session;

    public boolean addproductvideos(ViatorProductVideosBean viatorproductvideosBean){

        Transaction tx;
        boolean err=false;
        try{
            session = helper.getSession();
            tx=session.beginTransaction();
            session.save(viatorproductvideosBean);
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

    public boolean deleteProductVideos(String productCode){

        String hql = String.format("DELETE FROM ViatorProductVideosBean WHERE productCode='"+productCode+"'");
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

    public List<ViatorProductVideosBean> getVideosByProductCode(String productCode){

        List<ViatorProductVideosBean> videos=null;
        String hql ="Select videos FROM ViatorProductVideosBean videos " +
                                  "WHERE videos.productCode like :productCode " +
                                  "order by videos.sortOrder ";
        try{
            session = helper.getSession();
            session.beginTransaction();
            videos=session.createQuery(hql).setParameter("productCode",   productCode ).getResultList();
            session.getTransaction().commit();
            session.close();
        }catch (HibernateException e) {
            e.printStackTrace();
            session.close();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }
        return videos;
    }
}
