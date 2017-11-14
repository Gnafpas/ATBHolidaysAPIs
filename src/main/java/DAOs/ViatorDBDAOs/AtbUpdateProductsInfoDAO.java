package DAOs.ViatorDBDAOs;

import Beans.ViatorDBBeans.AtbUpdateProductsInfoBean;
import DBConnection.HibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;

/**
 * Created by George on 03/10/2017.
 */
public class AtbUpdateProductsInfoDAO {

    public static boolean addATBUpdateProductsInfo(AtbUpdateProductsInfoBean atbUpdateProductsInfoBean){

        Session session = HibernateUtil.getSession();
        Transaction tx;
        boolean err=false;
        try{
            tx=session.beginTransaction();
            session.save(atbUpdateProductsInfoBean);
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

    public static AtbUpdateProductsInfoBean getLastRecord(){

        Session session = HibernateUtil.getSession();
        String hql=     " select  updateInfo"
                      + " from Beans.ViatorDBBeans.AtbUpdateProductsInfoBean updateInfo"
                      + " order by updateInfo.rid DESC";
        AtbUpdateProductsInfoBean atbUpdateProductsInfoBean=null;
        try{
            Query query= session.createQuery(hql);
            query.setMaxResults(1);
            atbUpdateProductsInfoBean=(AtbUpdateProductsInfoBean)query.getSingleResult();
        }catch (HibernateException e) {
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return atbUpdateProductsInfoBean;
    }
}
