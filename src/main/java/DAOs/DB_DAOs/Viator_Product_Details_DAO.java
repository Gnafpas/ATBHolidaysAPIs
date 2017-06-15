package DAOs.DB_DAOs;


import DB_Beans.ViatorProductDetailsBean;
import DB_Connection.Main;
import org.hibernate.Session;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;

/**
 * Created by George on 15/06/2017.
 */
public class Viator_Product_Details_DAO {
    private Main helper;
    private Session session;

    public boolean addproduct(ViatorProductDetailsBean bid){

        Transaction tx = null;
        boolean err=false;
        try{
            session = helper.getSession();
//            tx=session.beginTransaction();
//            session.save(bid);
//            tx.commit();
            session.close();
        }catch (HibernateException e) {
            e.printStackTrace();
            session.close();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }

        return err;
    }
}
