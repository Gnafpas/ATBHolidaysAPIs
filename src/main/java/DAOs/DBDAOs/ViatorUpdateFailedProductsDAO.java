package DAOs.DBDAOs;

import DBBeans.ViatorUpdateFailedProductsBean;
import DBConnection.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by George on 08/07/2017.
 */
public class ViatorUpdateFailedProductsDAO {

    private HibernateUtil helper;
    private Session session;

    public boolean addViatorUpdateFailedProduct(ViatorUpdateFailedProductsBean viatorUpdateFailedProductsBean){

        Transaction tx;
        boolean err=false;
        try{
            session = helper.getSession();
            tx=session.beginTransaction();
            session.save(viatorUpdateFailedProductsBean);
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
