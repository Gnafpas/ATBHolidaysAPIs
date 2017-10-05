package DAOs.ATBDBDAOs.KalitaonSysDAOs;

import Beans.ATBDBBeans.KalitaonSystem.CityCodeBean;
import DBConnection.ATBSysHibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

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
            session.close();
        }catch (HibernateException e) {
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            e.printStackTrace();
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
            session.close();
        }catch (HibernateException e) {
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            e.printStackTrace();
        }
        return cities;
    }
}
