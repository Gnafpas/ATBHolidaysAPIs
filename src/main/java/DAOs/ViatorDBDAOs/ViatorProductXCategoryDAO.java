package DAOs.ViatorDBDAOs;

import Beans.ViatorDBBeans.ViatorCategoriesBean;
import Beans.ViatorDBBeans.ViatorProductXCategoryBean;
import DBConnection.HibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by George on 10/06/17.
 */
public class ViatorProductXCategoryDAO {

    public static boolean addprodactXcategory(ViatorProductXCategoryBean viatorproductXcategoryBean){

        Session session = HibernateUtil.getSession();
        Transaction tx;
        boolean err=false;
        try{
            session = HibernateUtil.getSession();
            tx=session.beginTransaction();
            session.save(viatorproductXcategoryBean);
            tx.commit();
            session.close();
        }catch (HibernateException e) {
            err=true;
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            err=true;
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            err=true;
            e.printStackTrace();
        }
        return err;
    }

    public static boolean deleteProductXCategory(String productCode){

        Session session = HibernateUtil.getSession();
        String hql = String.format("DELETE FROM ViatorProductXCategoryBean WHERE productCode='"+productCode+"'");
        boolean err=false;
        try{
            session.beginTransaction();
            session.createQuery(hql).executeUpdate();
            session.getTransaction().commit();
            session.close();
        }catch (HibernateException e) {
            err=true;
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            err=true;
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            err=true;
            e.printStackTrace();
        }
        return err;
    }

    public static List<ViatorCategoriesBean> getProductCategoriesByProductCode(String productCode){

        Session session = HibernateUtil.getSession();
        List<ViatorCategoriesBean> category=null;
        String hql ="Select category FROM ViatorProductXCategoryBean productXCategory ,ViatorCategoriesBean  category " +
                                    "WHERE productXCategory.productCode like :productCode " +
                                    "AND   category.id=productXCategory.categoryId " +
                                    "order by category.sortOrder ";
        try{
            session.beginTransaction();
            category=session.createQuery(hql).setParameter("productCode",   productCode ).getResultList();
            session.getTransaction().commit();
            session.close();
        }catch (HibernateException e) {
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            e.printStackTrace();
        }
        return category;
    }

}
