package DAOs.ATBDBDAOs.KalitaonSysDAOs;

import Beans.ATBDBBeans.KalitaonSystem.GsaBean;
import DBConnection.ATBSysHibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import com.sun.xml.internal.ws.client.ClientTransportException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static Controller.Application.errLogger;

/**
 * Created by George on 26/01/2018.
 */
public class GsaDAO {

    public static boolean updateGsaBean(GsaBean gsaBean) {

        Session session = ATBSysHibernateUtil.getSession();
        Transaction tx;
        boolean err = false;
        try {
            tx = session.beginTransaction();
            session.update(gsaBean);
            tx.commit();
        } catch (HibernateException e) {
            err = true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        } catch (ExceptionInInitializerError e) {
            err = true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        } catch (ClientTransportException e) {
            err = true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        } catch (CJCommunicationsException e) {
            err = true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        } finally {
            session.close();
        }
        return err;
    }

    public static GsaBean getGsaById(int id,StatelessSession session){

        boolean incomingSession=true;
        GsaBean gsaBean=null;
        String hql = "select gsaBean from GsaBean gsaBean where gsaBean.id = :id";
        try{
            if (session == null) {
                session = ATBSysHibernateUtil.getStatelessSession();
                session.beginTransaction();
                incomingSession = false;
            }
            gsaBean=(GsaBean)session.createQuery(hql).setParameter("id",id ).getSingleResult();
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
            if(!incomingSession)
                session.close();
        }
        return gsaBean;
    }

}
