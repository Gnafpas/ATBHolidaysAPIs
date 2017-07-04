package DAOs.DBDAOs;

import DBBeans.ViatorProductVideosBean;
import DBConnection.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
}
