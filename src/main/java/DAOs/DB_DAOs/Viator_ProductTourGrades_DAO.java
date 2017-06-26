package DAOs.DB_DAOs;

import DB_Beans.ViatorProductTourGradesBean;
import DB_Beans.ViatorProductUserPhotosBean;
import DB_Connection.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by George on 23/06/17.
 */
public class Viator_ProductTourGrades_DAO {
    private HibernateUtil helper;
    private Session session;

    public boolean addproducttourgrades(ViatorProductTourGradesBean viatorproducttourgradesBean ){

        Transaction tx;
        boolean err=false;
        try{
            session = helper.getSession();
            tx=session.beginTransaction();
            session.save(viatorproducttourgradesBean);
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
