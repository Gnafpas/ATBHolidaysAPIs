package DAOs.ViatorDBDAOs;

import APIJSONs.ATBAPIJSONs.Hotel.PrebookJSON;
import APIJSONs.ATBAPIJSONs.Hotel.PrebookPOST;
import Beans.ATBDBBeans.KalitaonSystem.SubAgencyBean;
import Beans.ViatorDBBeans.PrebookLogBean;
import DAOs.SunHotelsAPIDAOs.PreBookResult;
import DBConnection.HibernateUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import org.hibernate.HibernateException;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Timestamp;

import static Controller.Application.errLogger;

/**
 * Created by George on 06/04/2018.
 */
public class PrebookLogDAO {
    public static boolean addPrebookLogBean(PrebookLogBean prebookLogBean){

        StatelessSession session = HibernateUtil.getSession();
        Transaction tx;
        boolean err=false;
        try{
            tx=session.beginTransaction();
            session.insert(prebookLogBean);
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
