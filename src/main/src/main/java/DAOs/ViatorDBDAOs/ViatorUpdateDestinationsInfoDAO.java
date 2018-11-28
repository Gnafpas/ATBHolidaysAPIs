package DAOs.ViatorDBDAOs;

import Beans.ViatorDBBeans.ViatorUpdateDestinationsInfoBean;
import DBConnection.HibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

import java.io.PrintWriter;
import java.io.StringWriter;

import static Controller.Application.errLogger;

/**
 * Created by George on 26/07/2017.
 */
public class ViatorUpdateDestinationsInfoDAO {

    public static boolean addViatorUpdateDestinationsInfo(ViatorUpdateDestinationsInfoBean viatorUpdateDestinationsInfoBean){

        StatelessSession session = HibernateUtil.getSession();
        Transaction tx;
        boolean err=false;
        try{
            tx=session.beginTransaction();
            session.insert(viatorUpdateDestinationsInfoBean);
            tx.commit();
        }catch (HibernateException e) {
            err=true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ExceptionInInitializerError e) {
            err=true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (CJCommunicationsException e){
            err=true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }finally {
            session.close();
        }
        return err;
    }
}
