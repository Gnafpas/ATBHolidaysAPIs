package DAOs.DB_DAOs;

import DB_Beans.ViatorProductAdditionalInfoBean;
import DB_Beans.ViatorProductExclusionsBean;
import DB_Connection.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by George on 23/06/17.
 */
public class Viator_ProductExclusions_DAO {
    private HibernateUtil helper;
    private Session session;

    public boolean addproductexclusions(ViatorProductExclusionsBean viatorproductexclusionsBean){

        Transaction tx;
        boolean err=false;
        try{
            session = helper.getSession();
            tx=session.beginTransaction();
            session.save(viatorproductexclusionsBean);
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
