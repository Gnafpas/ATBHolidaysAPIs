package DAOs.DBDAOs;

import DBBeans.ViatorProductTourGradeLanguageServicesBean;
import DBBeans.ViatorProductTourGradesBean;
import DBConnection.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by George on 23/06/17.
 */
public class ViatorProductTourGradesDAO {
    private HibernateUtil helper;
    private Session session;

    public boolean addproducttourgrades(ViatorProductTourGradesBean viatorproducttourgradesBean ){

        Transaction tx;
        boolean err=false;
        try{
            session = helper.getSession();
            tx=session.beginTransaction();
            session.save(viatorproducttourgradesBean);
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

    public boolean deleteProductTourGrades(String productCode){

        String hql = String.format("DELETE FROM ViatorProductTourGradesBean WHERE productCode='"+productCode+"'");
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

    public List<ViatorProductTourGradesBean> getTourGradesByProductCode(String productCode){

        List<ViatorProductTourGradesBean> tourGrades=null;
        String hql ="Select tourGrades FROM ViatorProductTourGradesBean tourGrades " +
                                      "WHERE tourGrades.productCode like :productCode " +
                                      "order by tourGrades.sortOrder ";
        try{
            session = helper.getSession();
            session.beginTransaction();
            tourGrades=session.createQuery(hql).setParameter("productCode",   productCode ).getResultList();
            session.getTransaction().commit();
            session.close();
        }catch (HibernateException e) {
            e.printStackTrace();
            session.close();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }
        return tourGrades;
    }
}
