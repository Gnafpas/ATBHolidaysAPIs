package DAOs.DB_DAOs;

import DB_Beans.ViatorProductVideosBean;
import DB_Connection.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by George on 23/06/17.
 */
public class Viator_ProductVideos_DAO {
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
}
