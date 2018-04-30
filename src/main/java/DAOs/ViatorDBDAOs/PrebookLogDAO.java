package DAOs.ViatorDBDAOs;

import APIJSONs.ATBAPIJSONs.Hotel.PrebookJSON;
import APIJSONs.ATBAPIJSONs.Hotel.PrebookPOST;
import Beans.ATBDBBeans.KalitaonSystem.SubAgencyBean;
import Beans.ViatorDBBeans.PrebookLogBean;
import DAOs.SunHotelsAPIDAOs.PreBookResult;
import DBConnection.HibernateUtil;
import DBConnection.SunHotelsHibernateUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import com.sun.xml.internal.ws.client.ClientTransportException;
import org.hibernate.HibernateException;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import javax.persistence.NoResultException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Timestamp;
import java.util.List;

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

    public static PrebookLogBean getPrebookLogByRefAndProvider(String prebook_ref,StatelessSession session){


        boolean incomingSession=true;
        PrebookLogBean prebookLogBean=null;
        String hql = "select prebookLog from PrebookLogBean prebookLog where  prebookLog.prebookRef='"+prebook_ref+"'";
        try{
            if(session==null) {
                session =  HibernateUtil.getSession();
                session.beginTransaction();
                incomingSession=false;
            }
            prebookLogBean=(PrebookLogBean)session.createQuery(hql).getSingleResult();
        }catch (HibernateException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ExceptionInInitializerError e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ClientTransportException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (CJCommunicationsException e){
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (NoResultException e){

        }finally {
            if(!incomingSession)
                session.close();
        }
        return prebookLogBean;
    }


}
