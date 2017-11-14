package DAOs.ATBDBDAOs.KalitaonSysDAOs;

import Beans.ATBDBBeans.KalitaonSystem.CityCodeBean;
import DBConnection.ATBHibernateUtil;
import DBConnection.ATBSysHibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import java.util.List;

/**
 * Created by George on 18/09/2017.
 */
public class CityCodeDAO {

    public static List<CityCodeBean> getCountryCities(String countryCode){

        Session session = ATBSysHibernateUtil.getSession();
        List <CityCodeBean> cities=null;
        String hql = "select cities from CityCodeBean cities where countryCodeIso like :countryCode";
        try{
            session.beginTransaction();
            cities=session.createQuery(hql).setParameter("countryCode",  countryCode ).list();
        }catch (HibernateException e) {
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return cities;
    }

    public static List<CityCodeBean> getCities(){

        Session session = ATBSysHibernateUtil.getSession();
        List <CityCodeBean> cities=null;
        String hql = "select cities from CityCodeBean cities ";
        try{
            session.beginTransaction();
            cities=session.createQuery(hql).list();
        }catch (HibernateException e) {
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return cities;
    }

    public static boolean updatecity(CityCodeBean cityCodeBean) {
        Session session = ATBSysHibernateUtil.getSession();
        Transaction tx;
        boolean err = false;
        try {
            tx = session.beginTransaction();
            session.update(cityCodeBean);
            tx.commit();
        } catch (HibernateException e) {
            err = true;
            e.printStackTrace();
        } catch (ExceptionInInitializerError e) {
            err = true;
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            err=true;
            e.printStackTrace();
        }finally {
            session.close();
        }
        return err;

    }

    public static List<CityCodeBean> getCityByDetintationId(int destinationId){

        Session session = ATBSysHibernateUtil.getSession();
        List<CityCodeBean> cities=null;
        String hql = "select cities from CityCodeBean cities  where cities.viatorid = :destinationId";
        try{
            session.beginTransaction();
            cities=session.createQuery(hql).setParameter("destinationId",  destinationId ).list();
        }catch (HibernateException e) {
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }catch (NoResultException e){
        }finally {
            session.close();
        }
        return cities;
    }
}
