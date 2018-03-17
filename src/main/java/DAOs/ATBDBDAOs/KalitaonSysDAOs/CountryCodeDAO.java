package DAOs.ATBDBDAOs.KalitaonSysDAOs;

import Beans.ATBDBBeans.KalitaonSystem.CountryCodeBean;
import DBConnection.ATBSysHibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import com.sun.xml.internal.ws.client.ClientTransportException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.persistence.NoResultException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import static Controller.Application.errLogger;

/**
 * Created by George on 18/09/2017.
 */
public class CountryCodeDAO {

    public static List<CountryCodeBean> getCountries(){

        Session session = ATBSysHibernateUtil.getSession();
        List <CountryCodeBean> countries=null;
        String hql = "select countries from CountryCodeBean countries";
        try{
            session.beginTransaction();
            countries=session.createQuery(hql).list();
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
        return countries;
    }

    public static CountryCodeBean getCountryByCodeIso(String codeIso){
        Session session = ATBSysHibernateUtil.getSession();
        CountryCodeBean country=null;
        String hql = "select countries from CountryCodeBean countries where countries.isoCode = :codeIso";
        try{
            session.beginTransaction();
            country=(CountryCodeBean)session.createQuery(hql).setParameter("codeIso", codeIso).getSingleResult();
        }catch (HibernateException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ExceptionInInitializerError e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (CJCommunicationsException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (NoResultException e){
        }finally {
            session.close();
        }
        return country;
    }

    public static CountryCodeBean getCountryBycountryName(String countryName){
        Session session = ATBSysHibernateUtil.getSession();
        CountryCodeBean country=null;
        String hql = "select countries from CountryCodeBean countries where countries.countryName = :countryName";
        try{
            session.beginTransaction();
            country=(CountryCodeBean)session.createQuery(hql).setParameter("countryName", countryName).getSingleResult();
        }catch (HibernateException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ExceptionInInitializerError e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (CJCommunicationsException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (NoResultException e){
        }finally {
            session.close();
        }
        return country;
    }

    public static boolean storeCountryCode(CountryCodeBean countryCodeBean){

        boolean error=false;
        Session session = ATBSysHibernateUtil.getSession();
        try{
            session.beginTransaction();
            session.save(countryCodeBean);
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


}
