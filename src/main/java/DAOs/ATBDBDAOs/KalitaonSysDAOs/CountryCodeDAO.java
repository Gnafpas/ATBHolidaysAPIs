package DAOs.ATBDBDAOs.KalitaonSysDAOs;

import Beans.ATBDBBeans.KalitaonSystem.CountryCodeBean;
import DBConnection.ATBSysHibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.persistence.NoResultException;
import java.util.List;

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
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            e.printStackTrace();
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
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }catch (CJCommunicationsException e) {
            e.printStackTrace();
        }catch (NoResultException e){
        }finally {
            session.close();
        }
        return country;
    }


}
