package DAOs.DBDAOs;

import DBBeans.ViatorProductTourGradeLanguageServicesBean;
import DBConnection.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by George on 23/06/17.
 */
public class ViatorProductTourGradeLanguageServicesDAO {
    private HibernateUtil helper;
    private Session session;

    public boolean addproducttourgradelanguageservicesBean(ViatorProductTourGradeLanguageServicesBean viatorproducttourgradelanguageservicesBean){

        Transaction tx;
        boolean err=false;
        try{
            session = helper.getSession();
            tx=session.beginTransaction();
            session.save(viatorproducttourgradelanguageservicesBean);
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

    public boolean deleteProductTourGradeLanguageServices(String productCode){

        String hql = String.format("DELETE FROM ViatorProductTourGradeLanguageServicesBean WHERE productCode='"+productCode+"'");
        boolean err=false;
        try{
            session = helper.getSession();
            session.beginTransaction();
            session.createQuery(hql).executeUpdate();
            session.getTransaction().commit();
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
}
