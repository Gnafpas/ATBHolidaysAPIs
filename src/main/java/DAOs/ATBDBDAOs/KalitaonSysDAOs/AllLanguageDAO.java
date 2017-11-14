package DAOs.ATBDBDAOs.KalitaonSysDAOs;

import Beans.ATBDBBeans.KalitaonSystem.AllLanguageBean;
import DBConnection.ATBSysHibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by George on 21/08/2017.
 */
public class AllLanguageDAO {

    public static List<AllLanguageBean> getAllLanguages(){

        Session session = ATBSysHibernateUtil.getSession();
        List <AllLanguageBean> languages=null;
        String hql = "select languages from AllLanguageBean languages";
        try{
            session.beginTransaction();
            languages=session.createQuery(hql).list();
        }catch (HibernateException e) {
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return languages;
    }
}
