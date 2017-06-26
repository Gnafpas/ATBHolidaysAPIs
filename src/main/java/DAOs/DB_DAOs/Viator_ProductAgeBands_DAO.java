package DAOs.DB_DAOs;

import DB_Beans.ViatorCategoriesBean;
import DB_Beans.ViatorProductAgeBandsBean;
import DB_Connection.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by George on 20/06/17.
 */
public class Viator_ProductAgeBands_DAO {

    private HibernateUtil helper;
    private Session session;

    public boolean addproductagebandsBean(ViatorProductAgeBandsBean viatorproductagebandsBean){

        Transaction tx;
        boolean err=false;
        try{
            session = helper.getSession();
            tx=session.beginTransaction();
            session.save(viatorproductagebandsBean);
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
