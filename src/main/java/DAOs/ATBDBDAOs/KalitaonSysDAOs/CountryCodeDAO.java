package DAOs.ATBDBDAOs.KalitaonSysDAOs;

import Beans.ATBDBBeans.KalitaonSystem.CountryCodeBean;
import DBConnection.ATBSysHibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

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
            session.close();
        }catch (HibernateException e) {
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            e.printStackTrace();
        }
        return countries;
    }
}
