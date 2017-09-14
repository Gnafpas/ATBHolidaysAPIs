package DAOs.DBDAOs;

import DBBeans.ViatorUpdateProductsInfoBean;
import DBConnection.HibernateUtil;
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
            session.close();
        }catch (HibernateException e) {
            err=true;
            e.printStackTrace();
            session.close();
        }catch (ExceptionInInitializerError e) {
            err=true;
            e.printStackTrace();
        }
        return err;
    }

    public static ViatorUpdateProductsInfoBean getLastRecord(){

        Session session = HibernateUtil.getSession();
        String hql=     " select  updateInfo"
                + " from DBBeans.ViatorUpdateProductsInfoBean updateInfo"
                + " order by updateInfo.rid DESC";
        ViatorUpdateProductsInfoBean viatorUpdateProductsInfoBean=null;
        try{
            Query query= session.createQuery(hql);
            query.setMaxResults(1);
            viatorUpdateProductsInfoBean=(ViatorUpdateProductsInfoBean)query.getSingleResult();
            session.close();
        }catch (HibernateException e) {
            e.printStackTrace();
            session.close();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }
        return viatorUpdateProductsInfoBean;
    }
}
