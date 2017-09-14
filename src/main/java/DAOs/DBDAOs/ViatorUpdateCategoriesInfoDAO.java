package DAOs.DBDAOs;

import DBBeans.ViatorUpdateCategoriesInfoBean;
import DBConnection.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by George on 26/07/2017.
 */
public class ViatorUpdateCategoriesInfoDAO {

    public static boolean addViatorUpdateCategoriesInfo(ViatorUpdateCategoriesInfoBean viatorUpdateCategoriesInfoBean){
        Session session = HibernateUtil.getSession();
        Transaction tx;
        boolean err=false;
        try{
            tx=session.beginTransaction();
            session.persist(viatorUpdateCategoriesInfoBean);
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
