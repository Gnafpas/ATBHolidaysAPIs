package DAOs.ATBSysDAOs;

import ATBSysDBBeans.AllLanguageBean;
import DBConnection.ATBSysHibernateUtil;
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
            session.close();
        }catch (HibernateException e) {
            e.printStackTrace();
            session.close();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }
        return languages;
    }
}
