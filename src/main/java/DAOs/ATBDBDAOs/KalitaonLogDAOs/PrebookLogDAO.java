package DAOs.ATBDBDAOs.KalitaonLogDAOs;

import Beans.ATBDBBeans.KalitaonLog.PrebookLogBean;
import DBConnection.ATBLogHibernateUtil;
import DBConnection.ATBSysHibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import com.sun.xml.internal.ws.client.ClientTransportException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.persistence.NoResultException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static Controller.Application.errLogger;

/**
 * Created by George on 01/02/2018.
 */
public class PrebookLogDAO {

    public static boolean storePrebookLog(PrebookLogBean prebookLogBean){

        boolean error=false;
        Session session = ATBLogHibernateUtil.getSession();
        try{
            session.beginTransaction();
            session.save(prebookLogBean);
            session.getTransaction().commit();
        }catch (HibernateException e) {
            error=true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ExceptionInInitializerError e) {
            error=true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        } catch (ClientTransportException e) {
            error=true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (CJCommunicationsException e){
            error=true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (NoResultException e) {

        }finally{
            session.close();
        }
        return error;
    }

    public static PrebookLogBean getPrebookLogBeanByPrebookRef(String prebookRef){

        Session session = ATBLogHibernateUtil.getSession();
        PrebookLogBean prebookLogBean=null;
        String hql = "select prebookLogBean from PrebookLogBean prebookLogBean " +
                "where prebookLogBean.prebookRef like :prebookRef";
        try{
            session.beginTransaction();
            prebookLogBean=(PrebookLogBean)session.createQuery(hql).setParameter("prebookRef",prebookRef ).getSingleResult();
        }catch (HibernateException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ExceptionInInitializerError e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (NoResultException e) {
        }catch (CJCommunicationsException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return prebookLogBean;
    }
}
