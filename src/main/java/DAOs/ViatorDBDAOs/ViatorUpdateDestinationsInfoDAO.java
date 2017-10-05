package DAOs.ViatorDBDAOs;

import Beans.ViatorDBBeans.ViatorUpdateDestinationsInfoBean;
import DBConnection.HibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by George on 26/07/2017.
 */
public class ViatorUpdateDestinationsInfoDAO {

    public static boolean addViatorUpdateDestinationsInfo(ViatorUpdateDestinationsInfoBean viatorUpdateDestinationsInfoBean){

        Session session = HibernateUtil.getSession();
        Transaction tx;
        boolean err=false;
        try{
            tx=session.beginTransaction();
            session.persist(viatorUpdateDestinationsInfoBean);
            tx.commit();
            session.close();
        }catch (HibernateException e) {
            err=true;
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            err=true;
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            err=true;
            e.printStackTrace();
        }
        return err;
    }
}
