package DAOs.ATBDBDAOs.KalitaonSysDAOs;

import Beans.ATBDBBeans.KalitaonSystem.GsaBean;
import DBConnection.ATBSysHibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.persistence.NoResultException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static Controller.Application.errLogger;

/**
 * Created by George on 26/01/2018.
 */
public class GsaDAO {

    public static GsaBean getGsaById(int id){

        Session session = ATBSysHibernateUtil.getSession();
        GsaBean gsaBean=null;
        String hql = "select gsaBean from GsaBean gsaBean " +
                "where gsaBean.id = :id";
        try{
            session.beginTransaction();
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
            session.close();
        }
        return gsaBean;
    }

}
