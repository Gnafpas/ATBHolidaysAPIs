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

    public static int storePrebookLog(PrebookLogBean prebookLogBean){

        String hql ="Select prebookLog.id FROM PrebookLogBean prebookLog " +
               " order by prebookLog.id desc";
        Session session = ATBLogHibernateUtil.getSession();
        int id=0;
        try{
            session.beginTransaction();
            session.save(prebookLogBean);
            id = (int) session.createQuery(hql).setMaxResults(1)//todo check if this is safe and there is no possibility to get other record than the coorect one
                    .getSingleResult();
            session.getTransaction().commit();
        }catch (HibernateException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ExceptionInInitializerError e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        } catch (ClientTransportException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (CJCommunicationsException e){
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (NoResultException e) {

        }finally{
            session.close();
        }
        return id;
    }

    public static PrebookLogBean getPrebooklogBeanByPrebookRef(String prebooklogId,String prebookRef){

        Session session = ATBLogHibernateUtil.getSession();
        PrebookLogBean prebookLogBean=null;
        String hql="";
        if(prebooklogId!=null && !prebooklogId.equals("")) {
            hql= "select prebookLogBean from PrebookLogBean prebookLogBean " +
                    "where prebookLogBean.id = " + prebooklogId;
        }else {
            hql = "select prebookLogBean from PrebookLogBean prebookLogBean " +
                    "where prebookLogBean.prebookRef like  '" + prebookRef+"'";
        }
        try{
            session.beginTransaction();
            prebookLogBean=(PrebookLogBean)session.createQuery(hql).getSingleResult();
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
