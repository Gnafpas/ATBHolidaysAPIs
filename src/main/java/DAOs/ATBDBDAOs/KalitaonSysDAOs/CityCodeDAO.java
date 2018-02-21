package DAOs.ATBDBDAOs.KalitaonSysDAOs;

import Beans.ATBDBBeans.KalitaonSystem.CityCodeBean;
import DBConnection.ATBSysHibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import static Controller.Application.errLogger;

/**
 * Created by George on 18/09/2017.
 */
public class CityCodeDAO {

    public static List<CityCodeBean> getCountryCities(String countryCode){

        Session session = ATBSysHibernateUtil.getSession();
        List <CityCodeBean> cities=null;
        String hql = "select cities from CityCodeBean cities where countryCodeIso like :countryCode and hasProduct=true ";
        try{
            session.beginTransaction();
            cities=session.createQuery(hql).setParameter("countryCode",  countryCode ).list();
        }catch (HibernateException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ExceptionInInitializerError e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (CJCommunicationsException e){
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
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
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ExceptionInInitializerError e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (CJCommunicationsException e){
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
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
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        } catch (ExceptionInInitializerError e) {
            err = true;
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

    public static CityCodeBean getCityByGeonameId(String geonameid){

        Session session = ATBSysHibernateUtil.getSession();
        CityCodeBean city=null;
        String hql = "select cities from CityCodeBean cities  where cities.geonameid like :geonameid";
        try{
            session.beginTransaction();
            city=(CityCodeBean)session.createQuery(hql).setParameter("geonameid",  geonameid ).getSingleResult();
        }catch (HibernateException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ExceptionInInitializerError e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (NoResultException e){
        }finally {
            session.close();
        }
        return city;
    }
}
