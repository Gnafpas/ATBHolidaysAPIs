package DAOs.ViatorDBDAOs;

import Beans.ViatorDBBeans.ViatorUpdateProductsInfoBean;
import DBConnection.HibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;

/**
 * Created by George on 08/07/2017.
 */
public class ViatorUpdateProductsInfoDAO {

    public static boolean addViatorUpdateProductsInfo(ViatorUpdateProductsInfoBean viatorUpdateProductsInfoBean){

        Session session = HibernateUtil.getSession();
        Transaction tx;
        boolean err=false;
        try{
            tx=session.beginTransaction();
            session.persist(viatorUpdateProductsInfoBean);
            tx.commit();
        }catch (HibernateException e) {
            err=true;
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            err=true;
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            err=true;
            e.printStackTrace();
        }finally {
            session.close();
        }
        return err;
    }

    public static ViatorUpdateProductsInfoBean getLastRecord(){

        Session session = HibernateUtil.getSession();
        String hql=     " select  updateInfo"
                + " from Beans.ViatorDBBeans.ViatorUpdateProductsInfoBean updateInfo"
                + " order by updateInfo.rid DESC";
        ViatorUpdateProductsInfoBean viatorUpdateProductsInfoBean=null;
        try{
            Query query= session.createQuery(hql);
            query.setMaxResults(1);
            viatorUpdateProductsInfoBean=(ViatorUpdateProductsInfoBean)query.getSingleResult();
        }catch (HibernateException e) {
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return viatorUpdateProductsInfoBean;
    }
}
